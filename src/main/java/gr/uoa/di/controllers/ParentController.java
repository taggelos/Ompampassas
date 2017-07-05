package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.entities.ParentMetadata;
import gr.uoa.di.entities.Ticket;
import gr.uoa.di.services.EventService;
import gr.uoa.di.services.ParentMetadataService;
import gr.uoa.di.services.TicketService;
import gr.uoa.di.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller

public class ParentController {
    @Autowired
    private ParentMetadataService mParentMetadataService;

    @Autowired
    private UserService mUserService;

    @Autowired
    private EventService mEventService;

    @Autowired
    private TicketService mTicketService;

    @GetMapping({"/parent", "/parent/{urlname:.+}"})
    public ModelAndView getParent(@PathVariable(required = false) String urlname) {

        ModelAndView mav = new ModelAndView();
        ParentMetadata parent = mUserService.findByUsername(urlname).getParentMetadataById();
        System.out.println(parent.getUserId());
        mav.setViewName("parent");
        mav.addObject("parent", parent);

        Timestamp t = new Timestamp(new Date().getTime());
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket;
        Event event;
        long diffInDays;
        tickets.addAll(parent.getTicketsByUserId());
        for (Iterator<Ticket> iterator = tickets.iterator(); iterator.hasNext(); ) {
            ticket = iterator.next();
            event = ticket.getEventByEventId();
            diffInDays = (event.getStartTime().getTime() - t.getTime()) / (1000 * 60 * 60 * 24);
            if (diffInDays < 3) {
                iterator.remove();
            }
        }
        if (tickets.isEmpty())
            mav.addObject("message", "Δεν υπάρχουν διαθέσιμες κρατήσεις.");
        mav.addObject("tickets", tickets);

        return mav;
    }

    @PostMapping({"/parent", "/parent/{urlname:.+}"})
    public String postParent(@RequestParam(value = "event_id") String event_id,
                             @RequestParam(value = "ticket_id") String ticket_id,
                             @PathVariable(required = false) String urlname) {

        ParentMetadata parent = mUserService.findByUsername(urlname).getParentMetadataById();
        Event event = mEventService.findById(event_id);
        Ticket ticket = mTicketService.findById(ticket_id);

        Integer notickets = ticket.getNumOfTickets();
        event.setNumberOfTickets(event.getNumberOfTickets() + notickets);
        mEventService.save(event);

        mTicketService.delete(ticket_id);

        return "redirect:/parent/" + urlname;
    }
}