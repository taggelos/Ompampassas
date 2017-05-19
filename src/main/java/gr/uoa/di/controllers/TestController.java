package gr.uoa.di.controllers;

import gr.uoa.di.entities.ParentEntity;
import gr.uoa.di.entities.ProviderEntity;
import gr.uoa.di.entities.UserEntity;
import gr.uoa.di.repositories.ParentRepository;
import gr.uoa.di.repositories.ProviderRepository;
import gr.uoa.di.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TestController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private ProviderRepository providerRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/one")
    public String one() {
        return "onetest";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public @ResponseBody
    String addNewUser(@RequestParam Map<String, String> params) {

        /*
        check(params);

        params.get("inputName");
        params.get("inputSurname");
        params.get("inputUsername");
        params.get("inputEmail");
        params.get("inputPassword");
        params.get("inputConfirmPassword");
        params.get("inputPhone");
        params.get("inputDate");
        params.get("inputCompanyname");
        params.get("inputContactPhone");
        */

        if (params.get("inputPassword").equals(params.get("inputConfirmPassword"))) {
            //TODO hash password
            //params.put("inputPassword", sha256(params.get("inputPassword")));
            params.remove("inputConfirmPassword");
        } else {
            return "Bad password";
        }

        UserType kind;
        if ("Parent".equals(params.get("kind"))) kind = UserType.Parent;
        else if ("Provider".equals(params.get("kind"))) kind = UserType.Provider;
        else return "Bad kind";

        UserEntity n = new UserEntity();

        n.setEmail(params.get("inputEmail"));
        n.setPassword(params.get("inputPassword"));
        n.setName(params.get("inputName"));
        n.setSurname(params.get("inputSurname"));
        //n.setAge(69);
        System.out.println(params.get("inputEmail"));
        userRepository.save(n);

        switch (kind) {
            case Parent: {
                ParentEntity p = new ParentEntity();
                p.setUserId(n.getId());
                parentRepository.save(p);
                break;
            }
            case Provider: {
                ProviderEntity p = new ProviderEntity();
                p.setUserId(n.getId());
                providerRepository.save(p);
                break;
            }
        }

        return "Saved";
    }

    enum UserType {Parent, Provider}
}