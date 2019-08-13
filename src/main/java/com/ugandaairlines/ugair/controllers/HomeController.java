package com.ugandaairlines.ugair.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(path = "/")
    public String home(){
        return "pages/web/index";
    }

    @GetMapping(path = "/about")
    public String about(){
        return "pages/web/about";
    }

    @GetMapping(path = "/contact-us")
    public String contact(){
        return "pages/web/contact-us";
    }

    @GetMapping(path = "/faq")
    public String faq(){
        return "pages/web/faq";
    }

    @GetMapping(path = "/app/dashboard")
    public String dashboard(){
        return "pages/app/dashboard";
    }

}
