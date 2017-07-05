package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
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

        mav.setViewName("search");
        mav.addObject("events", filtered_events);
        mav.addObject("allcategories", all_categories);
        mav.addObject("allevents", all_events);
        return mav;
    }

    @GetMapping("/search")
    public ModelAndView getIndex(@RequestParam(value = "area") String area,
                                 @RequestParam(value = "keyword") String keyword,
                                 @RequestParam(value = "datetimepick") String datetime) {

        List<Event> events = new ArrayList<>();
        List<Event> allevents = mEventService.findAll();
        Set<String> allcategories = new HashSet<>();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

        Timestamp cur = new Timestamp(0);
        if(!datetime.isEmpty()) {
            try {
                Date d = df.parse(datetime);
                cur = new Timestamp(d.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        String[] keyword_parts = keyword.split(" ");

        for (Event e: allevents) {
            allcategories.add(e.getCategory());

            for(String i :keyword_parts) {
                if (( e.getCategory().toUpperCase().contains(i.toUpperCase()) ||  e.getTitle().toUpperCase().contains(i.toUpperCase()) || e.getDescription().toUpperCase().contains(i.toUpperCase()))
                        && !i.isEmpty()) {
                    if (!area.isEmpty()){
                        if (!datetime.isEmpty()) {
                            if (cur.after(e.getStartTime()) && cur.before(e.getEndTime())) {
                                if (e.getPlaceByPlaceId().getAddress().contains(area)) {
                                    events.add(e);
                                }
                            }
                        }
                        else{
                            if (e.getPlaceByPlaceId().getAddress().contains(area)) {
                                events.add(e);
                            }
                        }
                    }
                    else if(!datetime.isEmpty()){
                        if (cur.after(e.getStartTime()) && cur.before(e.getEndTime())) {
                            events.add(e);
                        }
                    }
                    else{
                        events.add(e);
                    }
                }
                else if(!area.isEmpty()){
                    if (!datetime.isEmpty()) {
                        if (cur.after(e.getStartTime()) && cur.before(e.getEndTime())) {
                            if (e.getPlaceByPlaceId().getAddress().contains(area)) {
                                events.add(e);
                            }
                        }
                    }
                    else{
                        if (e.getPlaceByPlaceId().getAddress().contains(area)) {
                            events.add(e);
                        }
                    }
                }
                else if(!datetime.isEmpty()){
                    if (cur.after(e.getStartTime()) && cur.before(e.getEndTime())) {
                        events.add(e);
                    }
                }

            }
        }

        ModelAndView mav = new ModelAndView();
        mav.setViewName("search");
        mav.addObject("events", events);
        mav.addObject("allcategories", allcategories);
        mav.addObject("allevents", allevents);
        return mav;
    }

}