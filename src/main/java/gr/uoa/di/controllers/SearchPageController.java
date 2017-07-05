package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.entities.Place;
import gr.uoa.di.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class SearchPageController {

    @Autowired
    private EventService mEventService;

    private static double distFrom(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (earthRadius * c);
    }

    @GetMapping("/search/{urlname:.+}")
    public ModelAndView getSearchbyFilters(@PathVariable(required = true) String urlname,
                                           @RequestParam(value = "rating",required = false) Integer rating,
                                           @RequestParam(value = "category_checkbox",required = false) String[] checkbox,
                                           @RequestParam(value = "price-min",required = false) Integer price_min,
                                           @RequestParam(value = "price-max",required = false) Integer price_max,
                                           @RequestParam(value = "datetimepick_filter",required = false) String datetime_filter) {

        ModelAndView mav = new ModelAndView();
        List<Event> filtered_events=new ArrayList<>();
        List<Event> all_events = mEventService.findAll();
        Set<String> all_categories = new HashSet<>();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Timestamp cur = null;
        if(!datetime_filter.isEmpty()) {
            try {
                Date d = df.parse(datetime_filter);
                cur = new Timestamp(d.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        for (Event ev: all_events) {
            all_categories.add(ev.getCategory());
        }

        if(checkbox!=null){
            for (Event ev: all_events) {
                for (String str : checkbox) {
                    if (str.contains(ev.getCategory())) {
                        if (!filtered_events.contains(ev)) {
                            filtered_events.add(ev);
                        }
                    }
                }
            }
        }
        else if(rating!=null){
            for (Event ev: all_events) {
                if (ev.getProviderMetadataByProviderId().getRating()>=rating) {
                    if (!filtered_events.contains(ev)) {
                        filtered_events.add(ev);
                    }
                }
            }
        }
        else if(price_min!=null){
            for (Event ev: all_events) {
                if (ev.getPrice()>=price_min) {
                    if (!filtered_events.contains(ev)) {
                        filtered_events.add(ev);
                    }
                }
            }
        }
        else if(price_max!=null){
            for (Event ev: all_events) {
                if (ev.getPrice()<=price_max) {
                    if (!filtered_events.contains(ev)) {
                        filtered_events.add(ev);
                    }
                }
            }
        }
        else if(!datetime_filter.isEmpty()){
            for (Event ev: all_events) {
                if (cur.after(ev.getStartTime()) && cur.before(ev.getEndTime())) {
                    if (!filtered_events.contains(ev)) {
                        filtered_events.add(ev);
                    }
                }
            }
        }

        if(rating!=null){
            for (Event fev: all_events) {
                if (fev.getProviderMetadataByProviderId().getRating()<rating) {
                    if (filtered_events.contains(fev)) {
                        filtered_events.remove(fev);
                    }
                }
            }
        }

        if(price_min!=null){
            for (Event fev: all_events) {
                if (fev.getPrice()<price_min) {
                    if (filtered_events.contains(fev)) {
                        filtered_events.remove(fev);
                    }
                }
            }
        }

        if(price_max!=null){
            for (Event fev: all_events) {
                if (fev.getPrice()>price_max) {
                    if (filtered_events.contains(fev)) {
                        filtered_events.remove(fev);
                    }
                }
            }
        }

        if(!datetime_filter.isEmpty()){
            for (Event fev: all_events) {
                if (cur.before(fev.getStartTime()) || cur.after(fev.getEndTime())) {
                    if (filtered_events.contains(fev)) {
                        filtered_events.remove(fev);
                    }
                }
            }
        }
        int sum;
        sum= filtered_events.size();

        mav.setViewName("search");
        mav.addObject("events", filtered_events);
        mav.addObject("allcategories", all_categories);
        mav.addObject("allevents", all_events);
        mav.addObject("sum", sum);
        mav.addObject("searchingfor", urlname);
        return mav;
    }

    @GetMapping("/search")
    public ModelAndView getIndex(@RequestParam(value = "area") String area,
                                 @RequestParam(value = "keyword") String keyword,
                                 @RequestParam(value = "longitude") String longitude,
                                 @RequestParam(value = "latitude") String latitude,
                                 @RequestParam(value = "datetimepick") String datetime) {

        List<Event> events = new ArrayList<>();
        List<Event> allevents = mEventService.findAll();
        Set<String> allcategories = new HashSet<>();
        Integer sum=0;


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

        Timestamp cur = new Timestamp(new Date().getTime());
        if(!datetime.isEmpty()) {
            try {
                Date d = df.parse(datetime);
                cur = new Timestamp(d.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        String[] keyword_parts;
        if (keyword.trim().length() > 0)
            keyword_parts = keyword.split(" ");
        else
            keyword_parts = new String[0];

        for (Event e : allevents) {
            allcategories.add(e.getCategory());

            if (!longitude.equals("")) {
                Place place = e.getPlaceByPlaceId();
                if (distFrom(place.getLatitude(), place.getLongitude(), Double.parseDouble(latitude), Double.parseDouble(longitude)) > 5)
                    continue;
            }
            if (cur.after(e.getStartTime())) {
                continue;
            }

            if (keyword_parts.length > 0) {
                for (String i : keyword_parts) {
                    if ((e.getCategory().toUpperCase().contains(i.toUpperCase()) || e.getTitle().toUpperCase().contains(i.toUpperCase()) || e.getDescription().toUpperCase().contains(i.toUpperCase()))
                            && !i.isEmpty()) {
                        events.add(e);
                        break;
                    }
                }
            } else
                events.add(e);

        }

        sum= events.size();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("search");
        mav.addObject("events", events);
        mav.addObject("allcategories", allcategories);
        mav.addObject("allevents", allevents);
        mav.addObject("sum", sum);
        mav.addObject("searchingfor", keyword);
        return mav;
    }

}