package gr.uoa.di.controllers;

import gr.uoa.di.entities.ParentsEntity;
import gr.uoa.di.entities.ProvidersEntity;
import gr.uoa.di.entities.UsersEntity;
import gr.uoa.di.repositories.ParentsRepository;
import gr.uoa.di.repositories.ProvidersRepository;
import gr.uoa.di.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import gr.uoa.di.controllers.SignUpController.UserType;

import java.util.Map;

@Controller
public class SignInController {
    @Autowired
    private UsersRepository mUsersRepository;
    @Autowired
    private ParentsRepository mParentsRepository;
    @Autowired
    private ProvidersRepository mProvidersRepository;

    @GetMapping("/signin")
    public String getSignin() {
        return "signin";
    }

    @PostMapping("/signin")
    public String postSignin(@RequestParam Map<String, String> params) {
        System.out.println(params.get("email")+"/"+params.get("password"));
        UsersEntity n = mUsersRepository.findByEmailAndPasswordIsLike(params.get("email"),params.get("password"));
        if (n==null){
            System.out.println("signin");
            return "signin";
        }
        System.out.println("profile");
        return "profile";
    }
}