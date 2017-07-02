package gr.uoa.di.controllers;

import gr.uoa.di.entities.User;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller

public class ProfileController {
    public static final String imagedir = System.getProperty("user.dir") + "/src/main/webapp/assets/imagedir/";

    @Autowired
    private UserService mUserService;

    @GetMapping({"/profile", "/profile/{urlname:.+}"})
    public ModelAndView getProfile(@PathVariable(required = false) String urlname) {
        ModelAndView mav = new ModelAndView();
        if (urlname == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            urlname = auth.getName(); //get logged in username
        }
        File theDir = new File(imagedir + urlname);
        Integer avatar = null;
        if (theDir.exists()) {
            for (File image : theDir.listFiles()) {
                avatar = Integer.parseInt(image.getName());
            }
        }
        User user = mUserService.findByUsername(urlname);
        mav.setViewName("profile");
        mav.addObject("user", user);
        if (avatar != null) mav.addObject("avatar", avatar);
        return mav;
    }

    /*@GetMapping("/uploadpic")
    public String upload(Model model) {
        File file = new File(imagedir);
        model.addAttribute("files", file.listFiles());
        return "/profile/";
    }*/

    @PostMapping({"/uploadpic", "/uploadpic/{urlname:.+}"})
    public String uploadingImg(@PathVariable(required = false) String urlname, @RequestParam("uploadingImgs") MultipartFile[] uploadingImgs) {
        // if the directory does not exist, create it
        if (urlname == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            urlname = auth.getName(); //get logged in username
        }
        File theDir = new File(imagedir + urlname);
        Integer avatar = 0;
        if (!theDir.exists()) {
            theDir.mkdir();
        } else {
            for (File image : theDir.listFiles()) {
                avatar = Integer.parseInt(image.getName()) + 1;
                image.delete();
            }
        }
        for (MultipartFile uploadedFile : uploadingImgs) {
            //uploadedFile.getOriginalFilename()
            File file = new File(imagedir + urlname + "/" + avatar);
            try {
                uploadedFile.transferTo(file);
            } catch (IOException ignored) {

            }
        }
        //config.setTemplateUpdateDelayMilliseconds(0);
        return "redirect:/profile/" + urlname;
    }

    @PostMapping({"/deletepic", "/deletepic/{urlname:.+}"})
    public String deletepicImg(@PathVariable(required = false) String urlname) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // if the directory does not exist, create it
        if (urlname == null) {
            urlname = auth.getName(); //get logged in username
        }

        File theDir = new File(imagedir + urlname);
        if (theDir.exists()) {
            for (File image : theDir.listFiles()) {
                image.delete();
            }
        }
        theDir.delete();

        return "redirect:/profile/" + urlname;
    }

}