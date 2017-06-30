package gr.uoa.di.controllers;

import gr.uoa.di.entities.Event;
import gr.uoa.di.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchPageController {

    @Autowired
    private EventService mEventService;

    @PostMapping("/search")
    public String postsearch() {
        return "search";
    }

    @GetMapping("/search")
    public String getIndex(@RequestParam(value = "area") String area,
                           @RequestParam(value = "keyword") String keyword,
                           @RequestParam(value = "datetimepick") String datetime,
                           @RequestParam(value = "nofk") Integer kids,
                           @RequestParam(value = "nofa") Integer adults){
        System.out.println(area);
        System.out.println(keyword);
        System.out.println(datetime);
        System.out.println(kids);
        System.out.println(adults);

        //List<Event> event = mEventService.findByCategoryOrTitleOrDescription(keyword,keyword,keyword);

        return "search";
    }


}