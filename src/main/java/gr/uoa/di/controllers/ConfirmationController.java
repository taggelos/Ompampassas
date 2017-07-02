package gr.uoa.di.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ConfirmationController {
    @GetMapping("/confirmation")
    public String getConfirmation() {
        return "confirmation";
    }

    @PostMapping("/confirmation")
    public String postConfirmation() {
        return "index";
    }

}