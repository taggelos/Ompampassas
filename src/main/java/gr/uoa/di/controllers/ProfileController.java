package gr.uoa.di.controllers;

import gr.uoa.di.entities.User;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        File theDir = new File(imagedir + name);
        // if the directory does not exist, create it
        if (!theDir.exists()) {
            try {
                theDir.mkdir();
            } catch (SecurityException se) {
                System.out.println("Problem Creating Directory: " + theDir.getName());
            }
        }
        for (MultipartFile uploadedFile : uploadingImgs) {
            //uploadedFile.getOriginalFilename()
            File file = new File(imagedir + name + "/" + "avatar");
            uploadedFile.transferTo(file);
        }
        //config.setTemplateUpdateDelayMilliseconds(0);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/deletepic", method = RequestMethod.POST)
    public String deletepicImg(@ModelAttribute("model") ModelMap model) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        File file = new File(imagedir + name + "/" + "avatar");
        file.delete();
        return "redirect:/profile";
    }
    @PostMapping("/profile")
    public @ResponseBody
    String postProfile(@RequestParam Map<String, String> params) {
        return "editprofile";
    }

}