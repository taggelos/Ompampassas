package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/search")
    public String postsearch() {
        return "search";
    }

    @GetMapping("/search")
    public ModelAndView getIndex(@RequestParam(value = "area") String area,
                           @RequestParam(value = "keyword") String keyword,
                           @RequestParam(value = "datetimepick") String datetime,
                           @RequestParam(value = "nofk") Integer kids,
                           @RequestParam(value = "nofa") Integer adults){

        List<Event> event=new ArrayList<>();//= mEventService.findByCategoryOrTitleOrDescription(keyword,keyword,keyword);
        List<Event> allevents = mEventService.findAll();

        System.out.println(datetime);
        System.out.println(area);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

        Timestamp cur=null;
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
        return mav;
    }


}