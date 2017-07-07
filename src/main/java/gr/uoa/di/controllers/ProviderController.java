package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.entities.ProviderMetadata;
import gr.uoa.di.services.ProviderMetadataService;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller

public class ProviderController {
    @Autowired
    private ProviderMetadataService mProviderService;
    @Autowired
    private UserService mUserService;

    @GetMapping("/provider/{urlname:.+}")
    public ModelAndView getProvider(@PathVariable String urlname) {

        ModelAndView mav = new ModelAndView();
        ProviderMetadata provider = mUserService.findByUsername(urlname).getProviderMetadataById();
        mav.setViewName("provider");
        mav.addObject("provider", provider);

        List<Event> events = new ArrayList<>();

        events.addAll(provider.getEventsByUserId());

        mav.addObject("events", events);

        return mav;
    }

    @PostMapping("/provider/{urlname:.+}")
    public String postProvider(@RequestParam(value = "stars") String stars,
                               @PathVariable(required = false) String urlname) {

        ProviderMetadata provider = mUserService.findByUsername(urlname).getProviderMetadataById();

        provider.setRating(provider.getRating() + Integer.valueOf(stars));
        provider.setNumberOfRatings(provider.getNumberOfRatings() + 1);
        mProviderService.save(provider);

        return "redirect:/provider/" + urlname;
    }
}