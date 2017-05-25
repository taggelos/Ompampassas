package gr.uoa.di.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String getProfile() {
        return "profile";
    }

    @PostMapping("/profile")
    public @ResponseBody
    String postProfile(@RequestParam Map<String, String> params) {
        System.out.print(params);
        return "editprofile";
    }

}