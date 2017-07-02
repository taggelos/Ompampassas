package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.entities.ProviderMetadata;
import gr.uoa.di.services.ProviderMetadataService;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller

public class ProviderController {
    @Autowired
    private ProviderMetadataService mProviderService;
    @Autowired
    private UserService mUserService;

    @GetMapping({"/provider", "/provider/{urlname:.+}"})
    public ModelAndView getProvider(@PathVariable(required = false) String urlname) {

        ModelAndView mav = new ModelAndView();
        System.out.println(urlname + "--->" + mUserService.findByUsername(urlname));
        ProviderMetadata provider = mUserService.findByUsername(urlname).getProviderMetadataById();
        System.out.println(provider.getCompanyName());
        mav.setViewName("provider");
        mav.addObject("provider", provider);

        List<Event> events = new ArrayList<>();

        events.addAll(provider.getEventsByUserId());

        mav.addObject("events", events);

        return mav;
    }

}