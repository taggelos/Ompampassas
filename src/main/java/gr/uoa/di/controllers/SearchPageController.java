package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SearchPageController {

    @Autowired
    private EventService mEventService;

    @GetMapping("/search/{urlname:.+}")
    public ModelAndView getSearchbyFilters(@PathVariable(required = true) String urlname,
                                           @RequestParam(value = "rating") Integer rating,
                                           @RequestParam(value = "category_checkbox") String[] checkbox,
                                           @RequestParam(value = "hiddn") String hidden,
                                           @RequestParam(value = "price-min") Integer price_min,
                                           @RequestParam(value = "price-max") Integer price_max,
                                           @RequestParam(value = "datetimepick_filter") String datetime_filter) {

        ModelAndView mav2 = new ModelAndView();
        List<Event> filtered_events=new ArrayList<>();
        List<Event> all_events = mEventService.findAll();
        List<String> all_categories = new ArrayList<>();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Timestamp cur=null;
        if(!datetime_filter.isEmpty()) {
            try {
                Date d = df.parse(datetime_filter);
                cur = new Timestamp(d.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        for (Event ev: all_events) {
            if(!all_categories.contains(ev.getCategory())) {
                all_categories.add(ev.getCategory());
            }
        }


        if(checkbox!=null && rating!=0 && price_min!=0 && price_max!=0 && !datetime_filter.isEmpty()  ){
            for (Event ev: all_events) {
                if(ev.getProviderMetadataByProviderId().getRating()>=rating && ev.getPrice()>price_min && ev.getPrice()<price_max && cur.after(ev.getStartTime()) && cur.before(ev.getEndTime())){
                    System.out.println("ok");
                    for(String str: checkbox) {
                        if(str.equals(ev.getCategory())) {
                            System.out.println(str);
                            filtered_events.add(ev);
                        }
                    }
                }
            }
        }

        mav2.setViewName("search");
        mav2.addObject("events", filtered_events);
        mav2.addObject("allcategories", all_categories);
        return mav2;



    }

    @GetMapping("/search")
    public ModelAndView getIndex(@RequestParam(value = "area") String area,
                           @RequestParam(value = "keyword") String keyword,
                           @RequestParam(value = "datetimepick") String datetime,
                           @RequestParam(value = "nofk") Integer kids,
                           @RequestParam(value = "nofa") Integer adults){

        List<Event> event=new ArrayList<>();//= mEventService.findByCategoryOrTitleOrDescription(keyword,keyword,keyword);
        List<Event> allevents = mEventService.findAll();
        List<String> allcategories = new ArrayList<>();


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

        //TODO: Check this code
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
            if(!allcategories.contains(e.getCategory())) {
                allcategories.add(e.getCategory());
            }

            for(String i :keyword_parts) {
                if (( e.getCategory().toUpperCase().contains(i.toUpperCase()) ||  e.getTitle().toUpperCase().contains(i.toUpperCase()) || e.getDescription().toUpperCase().contains(i.toUpperCase()))
                        && !i.isEmpty()) {
                    if (!area.isEmpty()){
                        if (!datetime.isEmpty()) {
                            if (cur.after(e.getStartTime()) && cur.before(e.getEndTime())) {
                                if (e.getPlaceByPlaceId().getAddress().contains(area)) {
                                    event.add(e);
                                }
                            }
                        }
                        else{
                            if (e.getPlaceByPlaceId().getAddress().contains(area)) {
                                event.add(e);
                            }
                        }
                    }
                    else if(!datetime.isEmpty()){
                        if (cur.after(e.getStartTime()) && cur.before(e.getEndTime())) {
                            event.add(e);
                        }
                    }
                    else{
                        event.add(e);
                    }
                }
                else if(!area.isEmpty()){
                    if (!datetime.isEmpty()) {
                        if (cur.after(e.getStartTime()) && cur.before(e.getEndTime())) {
                            if (e.getPlaceByPlaceId().getAddress().contains(area)) {
                                event.add(e);
                            }
                        }
                    }
                    else{
                        if (e.getPlaceByPlaceId().getAddress().contains(area)) {
                            event.add(e);
                        }
                    }
                }
                else if(!datetime.isEmpty()){
                    if (cur.after(e.getStartTime()) && cur.before(e.getEndTime())) {
                        event.add(e);
                    }
                }

            }
        }

        ModelAndView mav = new ModelAndView();
        mav.setViewName("search");
        mav.addObject("events", event);
        mav.addObject("allcategories", allcategories);
        return mav;
    }


}