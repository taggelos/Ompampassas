package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.services.EventService;
import gr.uoa.di.utils.Contstraints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class SearchPageController {

    @Autowired
    private EventService mEventService;

    @GetMapping("/search")
    public ModelAndView getSearchbyFilters(@RequestParam(value = "rating", required = false) Integer rating,
                                           @RequestParam(value = "category_checkbox", required = false) String[] checkbox,
                                           @RequestParam(value = "price-min", required = false) Integer price_min,
                                           @RequestParam(value = "price-max", required = false) Integer price_max,
                                           @RequestParam(value = "datetimepicker", required = false) String datetime,
                                           @RequestParam(value = "keyword", required = false) String keyword,
                                           @RequestParam(value = "longitude", required = false) String longitude,
                                           @RequestParam(value = "latitude", required = false) String latitude) {

        ModelAndView mav = new ModelAndView();
        List<Event> filtered_events = new ArrayList<>();
        List<Event> all_events = mEventService.findAll();
        Set<String> all_categories = new HashSet<>();

        Contstraints constraints = new Contstraints(rating, checkbox, price_min, price_max, datetime, keyword, longitude, latitude);

        for (Event e : all_events) {
            all_categories.add(e.getCategory());

            if (constraints.passAll(e))
                filtered_events.add(e);
        }

        int sum = filtered_events.size();
        mav.setViewName("search");
        if (sum > 0)
            mav.addObject("events", filtered_events);
        else
            mav.addObject("events", all_events);
        mav.addObject("allcategories", all_categories);
        mav.addObject("sum", sum);
        return mav;
    }

}
