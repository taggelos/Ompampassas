package gr.uoa.di.controllers;

import gr.uoa.di.entities.User;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditProfileController {
    @Autowired
    private UserService mUserService;
    @Autowired
    private BCryptPasswordEncoder mBCryptPasswordEncoder;

    @GetMapping({"/editprofile", "/editprofile/{urlname:.+}"})
    public ModelAndView getEditprofile(@PathVariable(required = false) String urlname) {
        ModelAndView mav = new ModelAndView();
        if (urlname == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            urlname = auth.getName(); //get logged in username
        }
        User user = mUserService.findByUsername(urlname);
        mav.setViewName("editprofile");
        mav.addObject("user", user);
        return mav;
    }

    @PostMapping({"/editprofile", "/editprofile/{urlname:.+}"})
    public ModelAndView postEditProfile(@RequestParam(value = "email") String email,
                                        @RequestParam(value = "name") String name,
                                        @RequestParam(value = "surname") String surname,
                                        @RequestParam(value = "password") String password,
                                        @RequestParam(value = "conf_password") String conf_password,
                                        @PathVariable(required = false) String urlname) {

        if (urlname == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            urlname = auth.getName(); //get logged in username
        }
        User user = mUserService.findByUsername(urlname);
        //TODO: user.setName(name);
        //TODO: user.setSurname(surname);
        if (!password.equals("")) {
            user.setPassword(mBCryptPasswordEncoder.encode(password));
        }
        user.setEmail(email);
        mUserService.update(user);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("profile");
        mav.addObject("user", user);
        return mav;
    }
}