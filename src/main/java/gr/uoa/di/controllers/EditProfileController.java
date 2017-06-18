package gr.uoa.di.controllers;

import gr.uoa.di.entities.User;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditProfileController {
    @Autowired
    private UserService mUserService;
    @Autowired
    private BCryptPasswordEncoder mBCryptPasswordEncoder;

    @GetMapping("/editprofile")
    public ModelAndView getEditprofile() {
        User user = new User();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username

        user.setEmail(mUserService.findByUsername(name).getEmail());
        user.setName(mUserService.findByUsername(name).getName());
        user.setSurname(mUserService.findByUsername(name).getSurname());

        ModelAndView mav = new ModelAndView();
        mav.setViewName("editprofile");
        mav.addObject("user", user);

        return mav;
    }

    @PostMapping("/editprofile")
    public ModelAndView postEditProfile(@RequestParam(value = "email") String email,
                                        @RequestParam(value = "name") String name,
                                        @RequestParam(value = "surname") String surname,
                                        @RequestParam(value = "password") String password,
                                        @RequestParam(value = "conf_password") String conf_password) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String temp = auth.getName(); //get logged in username

        User user = mUserService.findByUsername(temp);
        user.setName(name);
        user.setSurname(surname);
        if (!password.equals(""))
            user.setPassword(mBCryptPasswordEncoder.encode(password));

        user.setEmail(email);
        mUserService.update(user);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("profile");
        mav.addObject("user", user);
        return mav;
    }
}