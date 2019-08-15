package com.ugandaairlines.ugair.controllers;

import com.ugandaairlines.ugair.airport.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private IAirportService airportService;

    @Autowired
    public HomeController(IAirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping(path = "/")
    public String home(Model model){
        model.addAttribute("airports", airportService.findAllAirport());
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

}
