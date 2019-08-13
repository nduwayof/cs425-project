package com.ugandaairlines.ugair.controllers;

import com.ugandaairlines.ugair.airport.model.Airport;
import com.ugandaairlines.ugair.airport.service.IAirportService;
import com.ugandaairlines.ugair.flight.model.Flight;
import com.ugandaairlines.ugair.flight.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FlightController {
   @Autowired
   IFlightService iFlightService;
   IAirportService iAirportService;
    @RequestMapping("/app/flights/add-new-flight")
    public String addNewFlight(Model model){
        model.addAttribute("flight",new Flight());

        Iterable<Airport> airports = iAirportService.findAllAirport();
        model.addAttribute("airports",airports);
        return "pages/app/flights/new-flight";
    }

    @RequestMapping("/app/flights/saveflight")
    private String saveFlight(@ModelAttribute Flight flight){


        iFlightService.saveFlight(flight);


return null;
//        @OneToOne
//        private Airport departureAirport;
//        @OneToOne
//        private Airport arrivalAirport;
//        @OneToOne
//        private Aircraft aircraft;
//        @OneToMany(mappedBy = "flight")
//        List<FlightCost> flightCosts;
//        @OneToMany(mappedBy = "flight")
//        List<Booking> bookings;
    }
    @RequestMapping("/pages/apps/flights/flights")
    public ModelAndView customerList(@RequestParam(defaultValue = "0") int pageNo){
        ModelAndView modelAndView = new ModelAndView();
        Iterable<Flight> flights = iFlightService.findAllFlights();
        //long numberOfCustomers = flights.getTotalElements();
        modelAndView.addObject("currPageNo", pageNo);
        modelAndView.addObject("flights",flights);
        modelAndView.setViewName("pages/app/flights/flights");
        return modelAndView;
    }

}
