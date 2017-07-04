package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.entities.ParentMetadata;
import gr.uoa.di.entities.Ticket;
import gr.uoa.di.entities.User;
import gr.uoa.di.services.EventService;
import gr.uoa.di.services.ParentMetadataService;
import gr.uoa.di.services.TicketService;
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
    private static final String receiptdir = System.getProperty("user.dir") + "/src/main/webapp/assets/receipts/";

    @Autowired
    private EventService mEventService;

    @Autowired
    private UserService mUserService;

    @Autowired
    private TicketService mTicketService;

    @Autowired
    private ParentMetadataService mParentmetadataService;

    @GetMapping("/confirmation")
    public ModelAndView getConfirmation(@RequestParam(value = "point") String tickets, @RequestParam(value = "eventid") String eventid) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("confirmation");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String urlname = auth.getName(); //get logged in username
        User user = mUserService.findByUsername(urlname);
        Event event = mEventService.findById(eventid);
        ParentMetadata parent = user.getParentMetadataById();
        Integer notickets = Integer.parseInt(tickets);

        if (parent.getUserPoints() < notickets * event.getPrice())
            mav.addObject("error", "Δεν έχετε αρκετούς πόντους για αυτή την αγορά.");
        else if (event.getNumberOfTickets() < notickets)
            mav.addObject("error", "Δεν υπάρχουν αρκετές θέσεις για αυτή την αγορά.");
        else
            mav.addObject("message", "Μπορείτε να ολοκληρώσετε την αγοράς σας.");

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

            parent.setUserPoints(parent.getUserPoints() - notickets * event.getPrice());
            mParentmetadataService.save(parent);
            Ticket ticket = new Ticket();
            ticket.setEventByEventId(event);
            ticket.setParentMetadataByParentId(parent);
            ticket.setNumOfTickets(notickets);
            mTicketService.save(ticket);
            event.setNumberOfTickets(event.getNumberOfTickets() - notickets);
            mEventService.save(event);

            File file = new File(String.valueOf(receiptdir + "test.pdf"));
            HttpHeaders respHeaders = new HttpHeaders();
            MediaType mediaType = MediaType.parseMediaType("application/pdf");
            respHeaders.setContentType(mediaType);
            respHeaders.setContentLength(file.length());
            respHeaders.setContentDispositionFormData("attachment", file.getName());
            InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
            return new ResponseEntity<>(isr, respHeaders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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

}