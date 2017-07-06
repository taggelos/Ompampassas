package gr.uoa.di.utils;

import gr.uoa.di.entities.Event;
import gr.uoa.di.entities.Place;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

interface Checker {
    boolean pass(Event e);
}

public class Constraints {

    private List<Checker> constraints;

    public Constraints(Integer rating, String[] checkbox, Integer price_min, Integer price_max, String datetime, String keyword, String longitude, String latitude) {

        constraints = new LinkedList<>();

        if (rating != null) {
            constraints.add(new RatingChecker(rating));
        }
        if (checkbox != null) {
            constraints.add(new CategoryChecker(checkbox));
        }
        if (price_min != null) {
            constraints.add(new MinPriceChecker(price_min));
        }
        if (price_max != null) {
            constraints.add(new MaxPriceChecker(price_max));
        }
        if (longitude != null && !longitude.equals("")) {
            try {
                constraints.add(new LocationChecker(latitude, longitude));
            } catch (Exception ignored) {
            }
        }
        if (keyword != null && keyword.trim().length() > 0) {
            constraints.add(new FreeTextChecker(keyword));
        }

        constraints.add(new TimeChecker(datetime));
    }

    public boolean passAll(Event e) {
        return constraints.stream().filter(checker -> !checker.pass(e)).findAny().orElse(null) == null;
    }

}

class RatingChecker implements Checker {
    private final Integer rating;

    RatingChecker(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean pass(Event e) {
        return e.getProviderMetadataByProviderId().getRating() >= rating;
    }
}

class CategoryChecker implements Checker {
    private final String[] checkbox;

    CategoryChecker(String[] checkbox) {
        this.checkbox = checkbox;
    }

    @Override
    public boolean pass(Event e) {
        return Arrays.stream(checkbox).filter(category -> category.toUpperCase().equals(e.getCategory().toUpperCase())).findAny().orElse(null) != null;
    }
}

class MinPriceChecker implements Checker {
    private Integer price_min;

    MinPriceChecker(Integer price_min) {
        this.price_min = price_min;
    }

    @Override
    public boolean pass(Event e) {
        return e.getPrice() > price_min;
    }
}

class MaxPriceChecker implements Checker {
    private Integer price_max;

    MaxPriceChecker(Integer price_max) {
        this.price_max = price_max;
    }

    @Override
    public boolean pass(Event e) {
        return e.getPrice() < price_max;
    }
}

class TimeChecker implements Checker {
    private Timestamp cur;

    TimeChecker(String datetime) {
        cur = new Timestamp(new Date().getTime());
        if (datetime != null && !datetime.isEmpty()) {
            try {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
                Date d = df.parse(datetime);
                cur = new Timestamp(d.getTime());
            } catch (ParseException ignored) {
            }
        }
    }

    @Override
    public boolean pass(Event e) {
        return cur.before(e.getStartTime());
    }
}

class FreeTextChecker implements Checker {

    private final String[] keyword_parts;

    FreeTextChecker(String keyword) {
        keyword_parts = keyword.split(" ");
    }

    @Override
    public boolean pass(Event e) {
        return Arrays.stream(keyword_parts).filter(key -> !key.isEmpty() && freeTextLOL(e, key.toUpperCase())).findAny().orElse(null) != null;
    }

    private boolean freeTextLOL(Event e, String key) {
        return e.getCategory().toUpperCase().contains(key) ||
                e.getTitle().toUpperCase().contains(key) ||
                e.getDescription().toUpperCase().contains(key);
    }
}


class LocationChecker implements Checker {
    private Double latitude;
    private Double longitude;

    LocationChecker(String latitude, String longitude) {
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
    }

    @Override
    public boolean pass(Event e) {
        Place place = e.getPlaceByPlaceId();
        double lat1 = place.getLatitude();
        double lng1 = place.getLongitude();
        double dLat = Math.toRadians(latitude - lat1);
        double dLng = Math.toRadians(longitude - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(latitude)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (6371 * c) < 5;
    }

}
