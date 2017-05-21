package gr.uoa.di.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class SignInController {
    @GetMapping("/signin")
    public String getSignin() {
        return "signin";
    }

    @PostMapping("/signin")
    public @ResponseBody
    String postSignin(@RequestParam Map<String, String> params) {
        return "signin";
    }
}