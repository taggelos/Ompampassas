package gr.uoa.di.controllers;

import gr.uoa.di.entities.User;
import gr.uoa.di.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserRepository mUserRepository;

    //private List<User> userList;
    @GetMapping("admin")
    public String index(@ModelAttribute("model") ModelMap model) {
        return "admin/admin";
    }

    @PostMapping("admin")
    public ModelAndView admin(@RequestParam(value = "tables") String tables, @ModelAttribute("model") ModelMap model) {
        List<User> userList = new ArrayList<>();
        String resTable = null;
        if (tables.equals("all")) {
            mUserRepository.findAll().forEach(userList::add);
            resTable = "Όλοι οι χρήστες";
        } else if (tables.equals("admins")) {
            mUserRepository.findAll().forEach(user -> {
                if (user.getRole().equals("ROLE_ADMIN")) userList.add(user);
            });
            resTable = "Διαχειριστές";
        } else if (tables.equals("providers")) {
            mUserRepository.findAll().forEach(user -> {
                if (user.getRole().equals("ROLE_PROVIDER")) userList.add(user);
            });
            resTable = "Πάροχοι";
        } else if (tables.equals("parents")) {
            mUserRepository.findAll().forEach(user -> {
                if (user.getRole().equals("ROLE_PARENT")) userList.add(user);
            });
            resTable = "Γονείς";
        }
        if (userList.isEmpty()) {
            resTable = "Δεν υπάρχουν \"" + resTable + "\"";
        }
        model.addAttribute("userList", userList);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/admin");
        mav.addObject("resTable", resTable);
        return mav;
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

    @GetMapping("search_user")
    public String search_user() {
        return "admin/search_user";
    }

    @PostMapping("search_user")
    public ModelAndView search_user(@RequestParam(value = "keyword") String keyword) {
        List<User> userList = new ArrayList<>();
        String result = null;
        mUserRepository.findAll().forEach(user -> {
            if (user.getEmail().toUpperCase().contains(keyword.toUpperCase()) || user.getName().toUpperCase().contains(keyword.toUpperCase())
                    || user.getSurname().toUpperCase().contains(keyword.toUpperCase()))
                userList.add(user);
        });
        ModelAndView mav = new ModelAndView();
        if (userList.isEmpty()) {
            result = "Δεν υπάρχουν \"" + keyword + "\"";
        } else {
            result = "Αποτελέσματα για \"" + keyword + "\"";
        }
        mav.addObject("result", result);
        mav.addObject("userList", userList);
        mav.setViewName("admin/search_user");
        return mav;
    }
}