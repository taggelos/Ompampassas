package gr.uoa.di.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class EditProfileController {
    @GetMapping("/editprofile")
    public String EditProfile() {
        return "editprofile";
    }

    @PostMapping("/editprofile")
    public @ResponseBody
    String postEditProfile(@RequestParam Map<String, String> params) {
        return "editprofile";
    }
}