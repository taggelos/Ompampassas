package gr.uoa.di.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class Create_EventController {
    @GetMapping("/create_event")
    public String Create_Event() {
        return "create_event";
    }

    @PostMapping("/create_event")
    public @ResponseBody
    String postCreate_Event(@RequestParam Map<String, String> params) {
        return "create_event";
    }
}