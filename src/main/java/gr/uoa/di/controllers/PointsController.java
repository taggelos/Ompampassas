package gr.uoa.di.controllers;

import gr.uoa.di.entities.User;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PointsController {

    @Autowired
    private UserService mUserService;

    @GetMapping("/points")
    public String getPoints() {
        return "points";
    }

    @PostMapping("/points")
    public ModelAndView postPoints(@RequestParam(value = "points") String points,
                                   @RequestParam(value = "cardNumber") String cardNumber,
                                   @RequestParam(value = "cvvCode") String cvvCode) {

        ModelAndView mav = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String urlname = auth.getName();
        User user = mUserService.findByUsername(urlname);
        user.getParentMetadataById().setPoints(user.getParentMetadataById().getPoints() + Integer.parseInt(points));
        mUserService.update(user);
        mav.setViewName("redirect:/");
        if (cardNumber.matches(".*[a-zA-Z].*")) {
            mav.addObject("error", "Λάθος αριθμός κάρτας.");
            mav.setViewName("/points");
        }
        if (cvvCode.matches(".*[a-zA-Z].*")) {
            mav.addObject("error2", "Λάθος αριθμός CVV.");
            mav.setViewName("/points");
        }

        return mav;
    }
}