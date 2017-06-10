package gr.uoa.di.controllers;

import gr.uoa.di.entities.UsersEntity;
import gr.uoa.di.forms.RegisterForm;
import gr.uoa.di.services.SecurityService;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@SessionAttributes("curusername")
public class AuthController {
    @Autowired
    private UserService mUserService;

    @Autowired
    private SecurityService mSecurityService;

    @Autowired
    private Validator mValidator;

    @GetMapping("/login")
    public ModelAndView getLogin(@RequestParam(value = "error", required = false) String error,
                                 @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth/login");

        if (error != null)
            modelAndView.addObject("error", "Το Email ή/και ο Κωδικός Πρόσβασης που εισάγατε είναι λάθος. Παρακαλούμε προσπαθήστε ξανά.");
        if (logout != null)
            modelAndView.addObject("message", "Έχετε αποσυνδεθεί επιτυχώς.");

        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView getRegister() {
        ModelAndView mav = new ModelAndView("auth/register");
        mav.addObject("registerForm", new RegisterForm());
        return mav;
    }

    @PostMapping("/register")
    public ModelAndView postRegister(@ModelAttribute("registerForm") RegisterForm registerForm, BindingResult bindingResult, HttpServletRequest request) {
        Set<ConstraintViolation<RegisterForm>> errors = mValidator.validate(registerForm);

        if (!errors.isEmpty()) {
            ModelAndView mav = new ModelAndView("auth/register", bindingResult.getModel());
            mav.addObject("registerForm", registerForm);
            mav.addObject("errors", errors);

            return mav;
        }

        UsersEntity user = new UsersEntity();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setEnabled(true);
        user.setRole("ROLE_ADMIN");
        mUserService.save(user);

        mSecurityService.autologin(user.getEmail(), user.getPassword());

        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("registered", "REGISTER OK");

        return mav;
    }
}