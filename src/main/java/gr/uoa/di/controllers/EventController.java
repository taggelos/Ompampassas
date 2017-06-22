package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.entities.User;
import gr.uoa.di.services.EventService;
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
                                         @RequestParam(value = "notickets") int notickets) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String temp = auth.getName();
        User user = mUserService.findByUsername(temp);
        Event event = new Event();
        event.setProviderId(user.getId());
        event.setTitle(title);
        event.setDescription(description);
        event.setCategory(category);
        event.setNumberOfTickets(notickets);

        event.setProviderId(user.getId());

        System.out.println("C==================3" + start);
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
        System.out.println("C==================3" + x);

        event.setStartTime(x);
        event.setEndTime(y);

        //event.setPlaceId();
        mEventService.save(event);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("profile");
        mav.addObject("user", user);
        return mav;
    }
}