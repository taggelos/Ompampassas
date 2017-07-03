package gr.uoa.di.controllers.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping("/login")
    public ModelAndView getLogin(@RequestParam(value = "error", required = false) String error,
                                 @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!"anonymousUser".equals(auth.getName())) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }

        modelAndView.setViewName("auth/login");

        if (error != null)
            modelAndView.addObject("error", "Το Email ή/και ο Κωδικός Πρόσβασης που εισάγατε είναι λάθος. Παρακαλούμε προσπαθήστε ξανά.");
        if (logout != null)
            modelAndView.addObject("message", "Έχετε αποσυνδεθεί επιτυχώς.");

        return modelAndView;
    }
}
