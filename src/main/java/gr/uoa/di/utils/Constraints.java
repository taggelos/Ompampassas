package gr.uoa.di.utils;

import gr.uoa.di.entities.Event;
import gr.uoa.di.entities.Place;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

interface Checker {
    boolean pass(Event e);
}

public class Constraints {

    private List<Checker> constraints;

    public Constraints(Integer rating, List<String> checkbox, Integer price_min, Integer price_max, Timestamp cur, List<String> keyword_parts, Place location) {

        constraints = new LinkedList<>();

        if (rating != null) {
            constraints.add(e -> e.getProviderMetadataByProviderId().getRating() >= rating);
        }
        if (checkbox != null) {
            constraints.add(e -> checkbox.contains(e.getCategory()));
        }
        if (price_min != null) {
            constraints.add(e -> e.getPrice() > price_min);
        }
        if (price_max != null) {
            constraints.add(e -> e.getPrice() < price_max);
        }
        if (location != null) {
            constraints.add(e -> LocationDistance.distance(e.getPlaceByPlaceId(), location) < 5);
        }
        if (keyword_parts != null) {
            constraints.add(e -> FreeTextSearch.check(e, keyword_parts));
        }

        constraints.add(e -> cur.before(e.getStartTime()));
    }

    public boolean passAll(Event e) {
        return constraints.stream().filter(checker -> !checker.pass(e)).findAny().orElse(null) == null;
    }

}

class FreeTextSearch {

    static boolean check(Event e, List<String> keyword_parts) {
        return keyword_parts.stream().filter(key -> FreeTextSearch.matches(e, key)).findAny().orElse(null) != null;
    }

    private static boolean matches(Event e, String key) {
        return e.getCategory().toUpperCase().contains(key) ||
                e.getTitle().toUpperCase().contains(key) ||
                e.getDescription().toUpperCase().contains(key);
    }

}

class LocationDistance {
    static double distance(Place a, Place b) {

        double dLat = Math.toRadians(b.getLatitude() - a.getLatitude());
        double dLng = Math.toRadians(b.getLongitude() - a.getLongitude());
        double x = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(a.getLatitude())) * Math.cos(Math.toRadians(b.getLatitude())) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(x), Math.sqrt(1 - x));

        return (6371 * c);
    }

}
