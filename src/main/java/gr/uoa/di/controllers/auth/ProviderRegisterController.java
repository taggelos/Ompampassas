package gr.uoa.di.controllers.auth;

import gr.uoa.di.entities.User;
import gr.uoa.di.forms.auth.ProviderRegisterForm;
import gr.uoa.di.services.SecurityService;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ProviderRegisterController {
    @Autowired
    private UserService mUserService;

    @Autowired
    private SecurityService mSecurityService;

    @Autowired
    private Validator mValidator;

    @GetMapping("/register/provider")
    public ModelAndView getRegister() {
        ModelAndView mav = new ModelAndView("auth/register_provider");
        mav.addObject("registerForm", new ProviderRegisterForm());
        return mav;
    }

    @PostMapping("/register/provider")
    public ModelAndView postRegister(@ModelAttribute("registerForm") ProviderRegisterForm registerForm, BindingResult bindingResult, HttpServletRequest request) {
        Set<ConstraintViolation<ProviderRegisterForm>> errors = mValidator.validate(registerForm);

        if (!errors.isEmpty()) {
            ModelAndView mav = new ModelAndView("auth/register_provider", bindingResult.getModel());
            mav.addObject("registerForm", registerForm);
            mav.addObject("errors", errors);

            return mav;
        }

        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setEnabled(true);
        user.setRole("ROLE_PROVIDER");
        mUserService.save(user);

        // To autologin, we need to pass the password in plain text.
        String password = request.getParameter("password");
        mSecurityService.autologin(user.getEmail(), password);

        return new ModelAndView("redirect:/?registered=1");
    }
}