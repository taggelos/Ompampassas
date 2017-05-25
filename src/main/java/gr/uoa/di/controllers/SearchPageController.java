package gr.uoa.di.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchPageController {
    @GetMapping("/search")
    public String getsearch() {
        return "search";
    }

    @PostMapping("/search")
    public String postsearch() {
        return "search";
    }

}