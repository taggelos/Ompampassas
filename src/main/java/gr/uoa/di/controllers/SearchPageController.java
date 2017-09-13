package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.entities.Place;
import gr.uoa.di.services.EventService;
import gr.uoa.di.utils.Constraints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
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

        Timestamp cur = new Timestamp(new Date().getTime());
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
            Date d = df.parse(datetime);
            cur = new Timestamp(d.getTime());
        } catch (Exception ignored) {
        }

        if (keyword == null) keyword = "";
        List<String> keyword_parts = Arrays.stream(keyword.split(" ")).filter(key -> !key.isEmpty()).map(String::toUpperCase).collect(Collectors.toList());

        Place location;

        try {
            location = new Place();
            location.setLatitude(Double.parseDouble(latitude));
            location.setLongitude(Double.parseDouble(longitude));
        } catch (Exception ignored) {
            location = null;
        }

        Constraints constraints = new Constraints(rating, Arrays.asList(checkbox), price_min, price_max, cur, keyword_parts, location);

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
        if (!keyword.trim().isEmpty())
            mav.addObject("keyword", keyword.trim());
        mav.addObject("sum", sum);
        return mav;
    }

}
