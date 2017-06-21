package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.entities.User;
import gr.uoa.di.services.EventService;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {
    @Autowired
    private EventService mEventService;
    @Autowired
    private UserService mUserService;

    @PostMapping("/create_event")
    public ModelAndView postcreate_event(@RequestParam(value = "title") String title,
                                         @RequestParam(value = "description") String description,
                                         @RequestParam(value = "category") String category,
                                         @RequestParam(value = "password") String password,
                                         @RequestParam(value = "notickets") Integer notickets) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String temp = auth.getName();
        User user = mUserService.findByUsername(temp);
        Event event = new Event();
        event.setProviderId(user.getId());
        event.setTitle(title);
        event.setDescription(description);
        event.setCategory(category);
        event.setNumberOfTickets(notickets);
        // event.setStartTime();
        //event.setEndTime();
        //event.setPlaceId();
        mEventService.save(event);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("profile");
        mav.addObject("user", user);
        return mav;
    }
}