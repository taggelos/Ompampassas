package gr.uoa.di.controllers;

import gr.uoa.di.entities.ParentsEntity;
import gr.uoa.di.entities.ProvidersEntity;
import gr.uoa.di.entities.UsersEntity;
import gr.uoa.di.forms.SignupForm;
import gr.uoa.di.repositories.ParentsRepository;
import gr.uoa.di.repositories.ProvidersRepository;
import gr.uoa.di.repositories.UsersRepository;
import javassist.bytecode.stackmap.TypeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class SignUpController {
    @Autowired
    private UsersRepository mUsersRepository;
    @Autowired
    private ParentsRepository mParentsRepository;
    @Autowired
    private ProvidersRepository mProvidersRepository;

    enum UserType {Parent, Provider}

    private static final Logger LOGGER = Logger.getLogger(TypeData.ClassName.class.getName());

    @GetMapping("/signup")
    public ModelAndView getSignup() {
        ModelAndView mav = new ModelAndView("signup");
        mav.addObject("signupForm", new SignupForm());
        return mav;
    }

    @PostMapping("/signup")
    public ModelAndView postSignup(@Valid @ModelAttribute("signupForm") SignupForm signupForm, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();

            ModelAndView mav = new ModelAndView("signup", bindingResult.getModel());
            mav.addObject("signupForm", signupForm);
            mav.addObject("errors", errors);

            return mav;
        }

        return new ModelAndView("index");

//        if (bindingResult.hasErrors()) {
//            return "signup";
//        }
//
//        return "redirect:/";

//        /*
//        check(params);
//
//        params.get("inputName");
//        params.get("inputSurname");
//        params.get("inputUsername");
//        params.get("inputEmail");
//        params.get("inputPassword");
//        params.get("inputConfirmPassword");
//        params.get("inputPhone");
//        params.get("inputDate");
//        params.get("inputCompanyname");
//        params.get("inputContactPhone");
//        */
//
//        if (params.get("inputPassword").equals(params.get("inputConfirmPassword"))) {
//            //TODO hash password
//            //params.put("inputPassword", sha256(params.get("inputPassword")));
//            params.remove("inputConfirmPassword");
//        }
//        else {
//            return "Bad password";
//        }
//
//        UserType kind;
//        if ("Parent".equals(params.get("kind"))) kind = UserType.Parent;
//        else if ("Provider".equals(params.get("kind"))) kind = UserType.Provider;
//        else return "Bad kind";
//
//        UsersEntity n = new UsersEntity();
//
//        n.setEmail(params.get("inputEmail"));
//        n.setPassword(params.get("inputPassword"));
//        n.setName(params.get("inputName"));
//        n.setSurname(params.get("inputSurname"));
//        //n.setAge(69);
//        System.out.println(params.get("inputEmail"));
//        mUsersRepository.save(n);
//
//        switch (kind) {
//            case Parent: {
//                ParentsEntity p = new ParentsEntity();
//                p.setUserId(n.getId());
//                mParentsRepository.save(p);
//                break;
//            }
//            case Provider: {
//                ProvidersEntity p = new ProvidersEntity();
//                p.setUserId(n.getId());
//                mProvidersRepository.save(p);
//                break;
//            }
//        }
//
//        return "Saved";
    }
}
