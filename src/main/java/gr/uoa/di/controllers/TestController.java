package gr.uoa.di.controllers;

import gr.uoa.di.entities.User;
import gr.uoa.di.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TestController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        return "index";
    }

    @GetMapping("/one")
    public String one(Map<String, Object> model) {
        return "onetest";
    }

    @GetMapping("/signup")
    public String signup(Map<String, Object> model) {
        return "signup";
    }

    @PostMapping("/signup")
    public @ResponseBody
    String addNewUser(@RequestParam String email, @RequestParam String password) {
        User n = new User();
        n.setEmail(email);
        n.setPassword(password);
        userRepository.save(n);
        return "Saved";
    }
}