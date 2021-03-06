package gr.uoa.di.controllers;

import gr.uoa.di.entities.ParentMetadata;
import gr.uoa.di.entities.ProviderMetadata;
import gr.uoa.di.entities.Ticket;
import gr.uoa.di.entities.User;
import gr.uoa.di.repositories.ParentMetadataRepository;
import gr.uoa.di.repositories.ProviderMetadataRepository;
import gr.uoa.di.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserRepository mUserRepository;
    @Autowired
    private ProviderMetadataRepository mProviderRepository;
    @Autowired
    private ParentMetadataRepository mParentRepository;

    @GetMapping("admin")
    public String index(@ModelAttribute("model") ModelMap model) {
        return "admin/admin";
    }

    @PostMapping("admin")
    public ModelAndView admin(@RequestParam(value = "tables") String tables) {
        List<User> userList = new ArrayList<>();
        String resTable = null;
        switch (tables) {
            case "all":
                mUserRepository.findAll().forEach(userList::add);
                resTable = "Όλοι οι χρήστες";
                break;
            case "admins":
                mUserRepository.findAll().forEach(user -> {
                    if (user.getRole().equals("ROLE_ADMIN")) userList.add(user);
                });
                resTable = "Διαχειριστές";
                break;
            case "providers":
                mUserRepository.findAll().forEach(user -> {
                    if (user.getRole().equals("ROLE_PROVIDER")) userList.add(user);
                });
                resTable = "Πάροχοι";
                break;
            case "parents":
                mUserRepository.findAll().forEach(user -> {
                    if (user.getRole().equals("ROLE_PARENT")) userList.add(user);
                });
                resTable = "Γονείς";
                break;
        }
        if (userList.isEmpty()) {
            resTable = "Δεν υπάρχουν \"" + resTable + "\"";
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/admin");
        mav.addObject("userList", userList);
        mav.addObject("resTable", resTable);
        return mav;
    }

    @GetMapping("statistics")
    public ModelAndView stats() {
        List<ProviderMetadata> providerList = mProviderRepository.findAll();
        int num_parents = 0, num_admins, num_all = 0;
        for (User user : mUserRepository.findAll()) {
            if (user.getRole().equals("ROLE_PARENT")) num_parents++;
            num_all++;
        }
        HashMap<ParentMetadata, Integer> hpars = new HashMap<>();
        int actives = 0, total = 0;
        for (ParentMetadata par : mParentRepository.findAll()) {
            Collection<Ticket> tickets = par.getTicketsByUserId();
            int sum = tickets.stream().mapToInt(ticket -> (ticket.getEventByEventId().getPrice()) * ticket.getNumOfTickets()).sum();
            hpars.put(par, sum);
            if (sum != 0) actives++;
            total += sum;
        }

        num_admins = num_all - num_parents - providerList.size();
        ModelAndView mav = new ModelAndView();
        mav.addObject("providerList", providerList);
        mav.addObject("num_providers", providerList.size());
        mav.addObject("num_parents", num_parents);
        mav.addObject("num_all", num_all);
        mav.addObject("num_admins", num_admins);
        mav.addObject("actives", actives);
        mav.addObject("hpars", hpars);
        mav.addObject("totalsum", total);
        mav.setViewName("admin/statistics");
        return mav;
    }

    @GetMapping("search_user")
    public String search_user() {
        return "admin/search_user";
    }

    @PostMapping("search_user")
    public ModelAndView search_user(@RequestParam(value = "keyword") String keyword) {
        List<User> userList = new ArrayList<>();
        mUserRepository.findAll().forEach(user -> {
            switch (user.getRole()) {
                case "ROLE_PARENT":
                    if (user.getParentMetadataById().getFirstName().toUpperCase().contains(keyword.toUpperCase())
                            || user.getParentMetadataById().getLastName().toUpperCase().contains(keyword.toUpperCase()))
                        userList.add(user);
                    break;
                case "ROLE_PROVIDER":
                    if (user.getProviderMetadataById().getCompanyName().toUpperCase().contains(keyword.toUpperCase())
                            || user.getProviderMetadataById().getTitle().toUpperCase().contains(keyword.toUpperCase()))
                        userList.add(user);
                    break;
            }
            if (user.getEmail().toUpperCase().contains(keyword.toUpperCase()))
                userList.add(user);
        });
        String result;
        if (userList.isEmpty()) {
            result = "Δεν υπάρχουν \"" + keyword + "\"";
        } else {
            result = "Αποτελέσματα για \"" + keyword + "\"";
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("result", result);
        mav.addObject("userList", userList);
        mav.setViewName("admin/search_user");
        return mav;
    }
}