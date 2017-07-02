package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class InfoPageController {

    @Autowired
    private EventService mEventService;

    @GetMapping({"/info", "/info/{urlname:.+}"})
    public ModelAndView getInfoPage(@PathVariable(required = false) String urlname){
        ModelAndView mav1 = new ModelAndView();
        Event eve = mEventService.findByTitle(urlname);
        mav1.setViewName("info");
        mav1.addObject("event", eve);
        return mav1;

    }

    /*@PostMapping({"/info", "/info/{urlname:.+}"})
    public ModelAndView postInfoPage(@RequestParam(value = "title") String title,
                                        @RequestParam(value = "name") String name,
                                        @RequestParam(value = "surname") String surname,
                                        @RequestParam(value = "password") String password,
                                        @RequestParam(value = "conf_password") String conf_password,
                                        @PathVariable(required = false) String urlname){
        ModelAndView mav = new ModelAndView();
        if (urlname == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            urlname = auth.getName(); //get logged in username
        }
        Event event = mEventService.findByTitle(urlname);
        mav.setViewName("info");
        mav.addObject("event", event);
        return mav;

    }*/

}