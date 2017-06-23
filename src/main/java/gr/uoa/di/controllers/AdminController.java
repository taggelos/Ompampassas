package gr.uoa.di.controllers;

import gr.uoa.di.entities.User;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    private static List<User> userList = new ArrayList<User>();
    @Autowired
    private UserService mUserService;

    @GetMapping("admin")
    public String index(@ModelAttribute("model") ModelMap model) {
        User user = new User();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username

        user.setEmail(mUserService.findByUsername(name).getEmail());
        user.setName(mUserService.findByUsername(name).getName());
        user.setSurname(mUserService.findByUsername(name).getSurname());

        User user2 = new User();
        user2.setEmail("asdsa");
        user2.setName("asdsa");
        user2.setSurname("asdsa");
        userList.add(user);
        ;
        userList.add(user2);

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