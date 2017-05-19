package gr.uoa.di.controllers;

import gr.uoa.di.entities.UserEntity;
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

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        return "index";
    }

    @GetMapping("/one")
    public String one(Map<String, Object> model) {
        return "onetest";
    }

    @GetMapping("/signup")
    public String signup(Map<String, Object> model) {
        return "signup";
    }

    @PostMapping("/signup")
    public @ResponseBody
    String addNewUser(@RequestParam Map<String,String> params) {

        /*
        check(params);

        param.get("inputName");
        param.get("inputSurname");
        param.get("inputUsername");
        param.get("inputEmail");
        param.get("inputPassword");
        param.get("inputConfirmPassword");
        param.get("inputPhone");
        param.get("inputDate");
        param.get("inputCompanyname");
        param.get("inputContactPhone");
        */

        UserEntity n = new UserEntity();

        n.setEmail(params.get("inputEmail"));
        n.setPassword(params.get("inputPassword"));
        n.setName(params.get("inputName"));
        n.setSurname(params.get("inputSurname"));
        n.setAge(69);
        System.out.println(params.get("inputEmail"));
        userRepository.save(n);

        if("Parent".equals(params.get("kind"))) {
            return "parent created";
        }
        return "Saved";
    }
}