package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.entities.ParentMetadata;
import gr.uoa.di.entities.User;
import gr.uoa.di.services.EventService;
import gr.uoa.di.services.ParentMetadataService;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;


@Controller
public class ConfirmationController {
    private static final String receiptdir = System.getProperty("user.dir") + "/src/main/resources/assets/receipts/";

    @Autowired
    private EventService mEventService;

    @Autowired
    private UserService mUserService;

    @Autowired
    private ParentMetadataService mParentmetadataService;

    @GetMapping("/confirmation")
    public ModelAndView getConfirmation(@RequestParam(value = "point") String tickets, @RequestParam(value = "eventid") String eventid) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("confirmation");
        Event event = mEventService.findById(eventid);
        mav.addObject("event", event);
        mav.addObject("tickets", Integer.parseInt(tickets));
        return mav;
    }

    @PostMapping("/confirmation")
    public ResponseEntity<InputStreamResource> downloadPdf(@RequestParam(value = "tickets") String tickets, @RequestParam(value = "eventid") String eventid) {

        RunnableOperation R1 = new RunnableOperation("Thread-1");
        R1.start();
        try {
            //mav.addObject("user", user);

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String urlname = auth.getName(); //get logged in username
            User user = mUserService.findByUsername(urlname);
            Event event = mEventService.findById(eventid);
            ParentMetadata parent = user.getParentMetadataById();
            Integer notickets = Integer.parseInt(tickets);
            if (parent.getUserPoints() >= notickets * event.getPrice()) {
                parent.setUserPoints(parent.getUserPoints() - notickets * event.getPrice());
                //mParentmetadataService.update(parent);
            }

            File file = new File(String.valueOf(receiptdir + "test.pdf"));
            HttpHeaders respHeaders = new HttpHeaders();
            MediaType mediaType = MediaType.parseMediaType("application/pdf");
            respHeaders.setContentType(mediaType);
            respHeaders.setContentLength(file.length());
            respHeaders.setContentDispositionFormData("attachment", file.getName());
            InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
            return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);
        } catch (Exception e) {
            //String message = "Errore nel download del file "+idForm+".csv; "+e.getMessage();
            //logger.error(message, e);
            return new ResponseEntity<InputStreamResource>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

class RunnableOperation implements Runnable {
    private Thread t;
    private String threadName;

    RunnableOperation(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}