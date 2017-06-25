package gr.uoa.di.controllers;

import gr.uoa.di.entities.User;
import gr.uoa.di.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserRepository mUserRepository;

    @GetMapping("admin")
    public String index(@ModelAttribute("model") ModelMap model) {
        List<User> userList = new ArrayList<>();
        mUserRepository.findAll().forEach(userList::add);
        model.addAttribute("userList", userList);
        return "admin/admin";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("user") String user) {

        //if (null != user && null != user.getFirstname()
        //        && null != user.getLastname() && !user.getFirstname().isEmpty()
        //       && !user.getLastname().isEmpty()) {

        //  synchronized (userList) {
        //    userList.add(user);
        // }

        // }
        return "redirect:admin";
    }

    @GetMapping("statistics")
    public String stats() {
        return "admin/statistics";
    }
}