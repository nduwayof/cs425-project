package com.ugandaairlines.ugair.controllers;



import com.ugandaairlines.ugair.airport.model.Airport;
import com.ugandaairlines.ugair.airport.service.IAirportService;
import com.ugandaairlines.ugair.flight.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private IAirportService airportService;

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

    @GetMapping(path = "/app/dashboard")
    public String dashboard(){
        return "pages/app/dashboard";
    }


}
