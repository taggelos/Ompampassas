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


@Controller
public class PointsController {

    @Autowired
    private UserService mUserService;

    @GetMapping("/points")
    public String getPoints() {
        return "points";
    }

    @PostMapping("/points")
    public String postPoints(@RequestParam(value = "points") String points) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String urlname = auth.getName();
        User user = mUserService.findByUsername(urlname);
        user.getParentMetadataById().setUserPoints(user.getParentMetadataById().getUserPoints() + Integer.parseInt(points));
        mUserService.save(user);
        return "redirect:/";
    }
}