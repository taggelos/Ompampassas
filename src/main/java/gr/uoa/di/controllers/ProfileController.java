package gr.uoa.di.controllers;

import gr.uoa.di.entities.UsersEntity;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ProfileController {
    @Autowired
    private UserService mUserService;


    /*public String getName(String username) {
        return mUserService.findByUsername(username).getName();
    } */

    @GetMapping("/profile")
    public String getProfile() {
        return "profile";
    }

    @PostMapping("/profile")
    public @ResponseBody
    String postProfile(@RequestParam Map<String, String> params) {



        return "editprofile";
    }

}