package gr.uoa.di.controllers.auth;

import gr.uoa.di.entities.User;
import gr.uoa.di.forms.auth.ParentRegisterForm;
import gr.uoa.di.services.SecurityService;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ParentRegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService mSecurityService;

    @Autowired
    private Validator mValidator;

    @GetMapping("/register/parent")
    public ModelAndView getRegister() {
        ModelAndView mav = new ModelAndView("auth/register_parent");
        mav.addObject("registerForm", new ParentRegisterForm());
        return mav;
    }

    @PostMapping("/register/parent")
    public String postRegister(@ModelAttribute("registerForm") ParentRegisterForm registerForm, BindingResult bindingResult, HttpServletRequest request,
                               final RedirectAttributes redirectAttributes) {
        Set<ConstraintViolation<ParentRegisterForm>> errors = mValidator.validate(registerForm);

        if (!errors.isEmpty()) {
            redirectAttributes.addFlashAttribute("errors", errors);
            redirectAttributes.addFlashAttribute("registerForm", registerForm);
            return "redirect:/register/parent";
        }

        User user = userService.createParent(registerForm);

        // To autologin, we need to pass the password in plain text.
        String password = registerForm.getPassword();
        mSecurityService.autologin(user.getEmail(), password);

        return "redirect:/";
    }
}