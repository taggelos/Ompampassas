package gr.uoa.di.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CreateEventController {
    @GetMapping("/create_event")
    public String Create_Event() {
        return "create_event";
    }

    @PostMapping("/create_event")
    public @ResponseBody
    String postCreate_Event() {
        return "create_event";
    }
}