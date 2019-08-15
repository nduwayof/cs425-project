package com.ugandaairlines.ugair.controllers;

import com.ugandaairlines.ugair.airport.service.IAirportService;
import com.ugandaairlines.ugair.config.smtp.IMailService;
import com.ugandaairlines.ugair.config.smtp.implementation.MailMessageTemplate;
import com.ugandaairlines.ugair.person.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.mail.internet.AddressException;

@Controller
public class HomeController {

    private IAirportService airportService;
    private IMailService mailService;

    @Autowired
    public HomeController(IAirportService airportService, IMailService mailService) {
        this.airportService = airportService;
        this.mailService = mailService;
    }

    @GetMapping(path = "/")
    public String home(Model model) {
        try {
            Passenger passenger = new Passenger() ;
            passenger.setFirstName("Fabrice");
            passenger.setLastName("Nduwayo");
            mailService.sendMailUsingTemplate("fnduwayo@mum.edu",
                    "nduwayof@gmail.com",
                    "Uganda Airlines",
                    new MailMessageTemplate().BookingConfirmation(passenger));
            model.addAttribute("airports", airportService.findAllAirport());
        }catch (Exception ex){

        }
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
