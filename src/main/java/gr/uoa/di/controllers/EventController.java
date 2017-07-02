package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.entities.Place;
import gr.uoa.di.entities.User;
import gr.uoa.di.services.EventService;
import gr.uoa.di.services.PlaceService;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class EventController {
    @Autowired
    private EventService mEventService;
    @Autowired
    private UserService mUserService;
    @Autowired
    private PlaceService mPlaceService;
    @GetMapping("/create_event")
    public String getCreate_event() {
        return "create_event";
    }

    @PostMapping("/create_event")
    public ModelAndView postCreate_event(@RequestParam(value = "title") String title,
                                         @RequestParam(value = "description") String description,
                                         @RequestParam(value = "category") String category,
                                         @RequestParam(value = "start") String start,
                                         @RequestParam(value = "end") String end,
                                         @RequestParam(value = "price") int price,
                                         @RequestParam(value = "area") String area,
                                         @RequestParam(value = "place_title") String place_title,
                                         @RequestParam(value = "longitude") String longitude,
                                         @RequestParam(value = "latitude") String latitude,
                                         @RequestParam(value = "notickets") int notickets) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String temp = auth.getName();
        User user = mUserService.findByUsername(temp);
        Event event = new Event();
        Place place = new Place();
        place.setTitle(place_title);
        place.setAddress(area);
        place.setLatitude(Float.valueOf(latitude));
        place.setLongitude(Float.valueOf(longitude));
        place = mPlaceService.save(place);

        event.setProviderMetadataByProviderId(user.getProviderMetadataById());
        event.setTitle(title);
        event.setPrice(price);
        event.setDescription(description);
        event.setCategory(category);
        event.setNumberOfTickets(notickets);


        Timestamp x = null;
        Timestamp y = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        try {
            Date d = df.parse(start);
            x = new Timestamp(d.getTime());
            d = df.parse(end);
            y = new Timestamp(d.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        event.setStartTime(x);
        event.setEndTime(y);
        event.setPlaceByPlaceId(place);
        mEventService.save(event);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("profile");
        mav.addObject("user", user);
        return mav;
    }

}