package gr.uoa.di.controllers;

import gr.uoa.di.entities.User;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller

public class ProfileController {
    public static final String imagedir = System.getProperty("user.dir") + "/src/main/webapp/assets/imagedir/";


    /*public String getName(String username) {
        return mUserService.findByUsername(username).getName();
    } */
    @Autowired
    private UserService mUserService;

    @GetMapping("/profile")
    public ModelAndView getProfile() {
        User user = new User();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username

        user.setEmail(mUserService.findByUsername(name).getEmail());
        user.setName(mUserService.findByUsername(name).getName());
        user.setSurname(mUserService.findByUsername(name).getSurname());

        ModelAndView mav = new ModelAndView();
        mav.setViewName("profile");
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping("/uploadpic")
    public String upload(Model model) {
        File file = new File(imagedir);
        model.addAttribute("files", file.listFiles());
        return "/profile";
    }

    @RequestMapping(value = "/uploadpic", method = RequestMethod.POST)
    public String uploadingImg(@RequestParam("uploadingImgs") MultipartFile[] uploadingImgs) throws IOException {
        for (MultipartFile uploadedFile : uploadingImgs) {
            File file = new File(imagedir + uploadedFile.getOriginalFilename());
            uploadedFile.transferTo(file);
        }

        return "redirect:/";
    }

    @PostMapping("/profile")
    public @ResponseBody
    String postProfile(@RequestParam Map<String, String> params) {



        return "editprofile";
    }

}