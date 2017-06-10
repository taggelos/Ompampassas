package gr.uoa.di.controllers;

import gr.uoa.di.entities.UsersEntity;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class EditProfileController {
    //@GetMapping("/editprofile")
    //public String EditProfile() {
    //    return "editprofile";
    //}

    @Autowired
    private UserService mUserService;

    @GetMapping("/editprofile")
    public ModelAndView getEditprofile() {
        UsersEntity user = new UsersEntity();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username

        user.setEmail(mUserService.findByUsername(name).getEmail());
        user.setName(mUserService.findByUsername(name).getName());
        user.setSurname(mUserService.findByUsername(name).getSurname());

        ModelAndView mav = new ModelAndView();
        mav.setViewName("editprofile");
        mav.addObject("user", user);

        return mav;
    }

    @PostMapping("/editprofile")
    public String postEditProfile(@RequestParam Map<String, String> params) {
        return "editprofile";
    }
}