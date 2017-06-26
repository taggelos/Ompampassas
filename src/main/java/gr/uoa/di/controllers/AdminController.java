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
        //System.out.println(tables + " sdjsadjasjdjasjasdAJAJAJAJAJAJJAJ");
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
        //System.out.println("ΗΕrΕ "+ resTable);
        if (userList.isEmpty()) {
            resTable = "Δεν υπάρχουν \"" + resTable + "\"";
        }
        //for (User u: userList){System.out.println(u.getEmail());}
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

    @GetMapping("features")
    public String features() {
        return "admin/features";
    }

    @PostMapping("features")
    public String features(@RequestParam(value = "email") String email) {
        System.out.println(email + "sdjsadjasjdjasjasdAJAJAJAJAJAJJAJ");
        return "admin/features";
    }
}