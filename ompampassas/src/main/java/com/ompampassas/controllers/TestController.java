package com.ompampassas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by aggel on 2/5/2017.
 */
@Controller
public class TestController {
    @RequestMapping("/")
    public String testList(){
        return "testhome";
    };


}
