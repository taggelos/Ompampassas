package gr.uoa.di.controllers.auth;

import gr.uoa.di.entities.TaxOffice;
import gr.uoa.di.entities.User;
import gr.uoa.di.forms.auth.ProviderRegisterForm;
import gr.uoa.di.services.SecurityService;
import gr.uoa.di.services.UserService;
import gr.uoa.di.utils.DatabaseUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Controller
public class ProviderRegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private Validator validator;

    @GetMapping("/register/provider")
    public ModelAndView getRegister(Model model) {
        Session session = DatabaseUtils.getSession();
        Query query = session.createQuery("from TaxOffice order by name asc");
        List<TaxOffice> taxOffices = (List<TaxOffice>) query.list();

        ProviderRegisterForm registerForm;
        // If we have flashed data (ie. from a failed validation), pass them into the view.
        if (model.asMap().get("registerForm") != null)
            registerForm = (ProviderRegisterForm) model.asMap().get("registerForm");
        else
            registerForm = new ProviderRegisterForm();

        ModelAndView mav = new ModelAndView("auth/register_provider");
        mav.addObject("registerForm", registerForm);
        mav.addObject("taxOffices", taxOffices);
        return mav;
    }

    @PostMapping("/register/provider")
    public String postRegister(@ModelAttribute("registerForm") ProviderRegisterForm registerForm, BindingResult bindingResult, HttpServletRequest request,
                               final RedirectAttributes redirectAttributes) {
        Set<ConstraintViolation<ProviderRegisterForm>> errors = validator.validate(registerForm);

        if (!errors.isEmpty()) {
            redirectAttributes.addFlashAttribute("errors", errors);
            redirectAttributes.addFlashAttribute("registerForm", registerForm);
            return "redirect:/register/provider";
        }

        User user = userService.createProvider(registerForm);

        // To autologin, we need to pass the password in plain text.
        String password = registerForm.getPassword();
        securityService.autologin(user.getEmail(), password);

        return "redirect:/";
    }
}