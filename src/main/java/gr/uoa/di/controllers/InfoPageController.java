package gr.uoa.di.controllers;

import gr.uoa.di.entities.Comment;
import gr.uoa.di.entities.Event;
import gr.uoa.di.entities.User;
import gr.uoa.di.repositories.CommentRepository;
import gr.uoa.di.services.EventService;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class InfoPageController {
    public static final String imagedir = System.getProperty("user.dir") + "/src/main/webapp/assets/imagedir/";

    @Autowired
    private EventService mEventService;
    @Autowired
    private CommentRepository repo;
    @Autowired
    private UserService userService;


    @GetMapping("/info/{urlname:.+}")
    public ModelAndView getInfoPage(@PathVariable String urlname) {
        ModelAndView mav1 = new ModelAndView();
        Event eve = mEventService.findById(urlname);
        mav1.setViewName("info");
        mav1.addObject("event", eve);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        File theDir = new File(imagedir + auth.getName());
        Integer avatar = null;
        if (theDir.exists()) {
            for (File image : theDir.listFiles()) {
                avatar = Integer.parseInt(image.getName());
            }
        }
        if (avatar != null) mav1.addObject("avatar", avatar);

        return mav1;
    }

    @PostMapping("/info/{urlname:.+}")
    public String postInfoPage(@PathVariable String urlname, @RequestParam String title, @RequestParam String description) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        Event eve = mEventService.findById(urlname);

        Comment comment = new Comment();
        comment.setEventByEventId(eve);
        comment.setUserByUserId(user);
        comment.setTitle(title);
        comment.setMessage(description);
        comment.setTimestamp(new Timestamp(new Date().getTime()));

        repo.save(comment);

        return "redirect:/info/" + eve.getId();
    }

    /*@PostMapping({"/info", "/info/{urlname:.+}"})
    public ModelAndView postInfoPage(@RequestParam(value = "title") String title,
                                        @RequestParam(value = "name") String name,
                                        @RequestParam(value = "surname") String surname,
                                        @RequestParam(value = "password") String password,
                                        @RequestParam(value = "conf_password") String conf_password,
                                        @PathVariable(required = false) String urlname){
        ModelAndView mav = new ModelAndView();
        if (urlname == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            urlname = auth.getName(); //get logged in username
        }
        Event event = mEventService.findByTitle(urlname);
        mav.setViewName("info");
        mav.addObject("event", event);
        return mav;

    }*/

}