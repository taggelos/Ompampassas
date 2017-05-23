package gr.uoa.di.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("admin")
    public String index() {
        return "admin/admin";
    }

    @GetMapping("statistics")
    public String stats() {
        return "admin/statistics";
    }
}