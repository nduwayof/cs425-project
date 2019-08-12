package com.ugandaairlines.ugair.home_controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(path = "/")
    public String home(){
        return "pages/web/index";
    }

}
