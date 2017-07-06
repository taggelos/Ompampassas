package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.services.EventService;
import gr.uoa.di.utils.Constraints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

        List<Event> filtered_events;
        List<Event> all_events = mEventService.findAll();
        Set<String> all_categories = new HashSet<>();

        Constraints constraints = new Constraints(rating, checkbox, price_min, price_max, datetime, keyword, longitude, latitude);

        filtered_events = all_events.stream()
                .peek(event -> all_categories.add(event.getCategory()))
                .filter(constraints::passAll)
                .collect(Collectors.toList());

        int sum = filtered_events.size();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("search");
        if (sum > 0)
            mav.addObject("events", filtered_events);
        else
            mav.addObject("events", all_events);
        mav.addObject("allcategories", all_categories);
        if (keyword != null && !keyword.trim().isEmpty())
            mav.addObject("keyword", keyword.trim());
        mav.addObject("sum", sum);
        return mav;
    }

}
