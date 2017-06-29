package gr.uoa.di.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("index");

        // TODO: What up with this?
        if (request.getParameter("registered") != null &&
                request.getParameter("registered").equals("1"))
            mav.addObject("registered", true);
        // ???

        String contactus = "axne@gmail.com";//δυναμικα
        mav.addObject("contactus", contactus);
        return mav;
    }
}