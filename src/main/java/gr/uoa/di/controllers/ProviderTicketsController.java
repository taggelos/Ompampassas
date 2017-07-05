package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.entities.Ticket;
import gr.uoa.di.services.EventService;
import gr.uoa.di.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Date;


@Controller
public class ProviderTicketsController {

    @Autowired
    private EventService mEventService;

    @Autowired
    private TicketService mTicketService;

    @GetMapping("/provider_tickets/{eventid:.+}")
    public ModelAndView getTickets(@PathVariable String eventid) {
        Event event = mEventService.findById(eventid);

        Timestamp t = new Timestamp(new Date().getTime());
        long diffInDays = (event.getStartTime().getTime() - t.getTime()) / (1000 * 60 * 60 * 24);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("provider_tickets");

        boolean flag = true;
        if (diffInDays < 3) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String temp = auth.getName();
            if (temp.equals(event.getProviderMetadataByProviderId().getUserByUserId().getEmail())) {
                mav.addObject("tickets", event.getTicketsById());
                flag = false;
            }
        }
        if (flag) {
            mav.addObject("tickets", null);
        }
        return mav;
    }

    @PostMapping("/provider_tickets")
    public ModelAndView postTickets(@RequestParam(value = "ticketid") String ticketid) {
        Ticket ticket = mTicketService.findById(ticketid);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("receipt/receipt");
        mav.addObject("ticket", ticket);
        return mav;
    }

}