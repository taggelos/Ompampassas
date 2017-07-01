package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
        for (Event e: allevents) {
            if((e.getCategory().contains(keyword) || e.getCategory().contains(keyword.toUpperCase())|| e.getCategory().contains(keyword.toLowerCase())
                    || e.getTitle().contains(keyword)  || e.getTitle().contains(keyword.toUpperCase())|| e.getTitle().contains(keyword.toLowerCase())
                    || e.getDescription().contains(keyword) || e.getDescription().contains(keyword.toUpperCase())|| e.getDescription().contains(keyword.toLowerCase()) ) ){
                event.add(e);
            }

        }


        ModelAndView mav = new ModelAndView();
        mav.setViewName("search");
        mav.addObject("events", event);
        return mav;
    }


}