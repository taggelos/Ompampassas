package gr.uoa.di.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InfoPageController {
    @GetMapping("/info")
    public String getInfo() {
        return "info";
    }

    @PostMapping("/info")
    public String postInfo() {
        return "info";
    }

}