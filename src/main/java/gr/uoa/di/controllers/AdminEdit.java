package gr.uoa.di.controllers;

import gr.uoa.di.entities.User;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminEdit {
    @Autowired
    private UserService mUserService;

    @GetMapping({"/editroles", "/editroles/{urlname:.+}"})
    public ModelAndView getAdmin(@PathVariable(required = false) String urlname) {
        ModelAndView mav = new ModelAndView();
        if (urlname == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            urlname = auth.getName(); //get logged in username
        }
        User user = mUserService.findByUsername(urlname);
        mav.setViewName("editroles");
        mav.addObject("user", user);
        return mav;
    }

    @PostMapping({"/editroles", "/editroles/{urlname:.+}"})
    public ModelAndView postAdmin(@RequestParam(value = "enable", required = false) String enable,
                                  @RequestParam(value = "roles", required = false) String roles,
                                  @PathVariable(required = false) String urlname) {
        User user = mUserService.findByUsername(urlname);
        //System.out.println(enable + " - " + roles + " - " + user.getRole());
        if (enable != null)
            if (enable.equals("enable")) user.setEnabled(true);
            else if (enable.equals("disable")) user.setEnabled(false);

        if (roles != null)
            if (roles.equals("provider")) user.setRole("ROLE_PROVIDER");
            else if (roles.equals("admin")) user.setRole("ROLE_ADMIN");
            else if (roles.equals("parent")) user.setRole("ROLE_PARENT");
        user = mUserService.update(user);

        //System.out.println(user.isEnabled() + " - " + roles + " - " + user.getRole());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("editroles");
        mav.addObject("user", user);
        return mav;
    }
}