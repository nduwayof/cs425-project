package com.ugandaairlines.ugair.controllers;

import com.ugandaairlines.ugair.airport.service.IAircraftService;
import com.ugandaairlines.ugair.airport.service.IAirportService;
import com.ugandaairlines.ugair.flight.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlightController {

    private IAirportService airportService;
    private IAircraftService aircraftService;

    @Autowired
    public FlightController(IAirportService airportService, IAircraftService aircraftService){
        this.airportService = airportService;
        this.aircraftService = aircraftService;
    }

    @GetMapping(path = "/app/flights")
    public String flights(){
        return "pages/app/flights/flights";
    }

    @GetMapping(path = "/app/flight/new")
    public String newFlight(Model model){
        model.addAttribute("flight",  new Flight());
        model.addAttribute("airports", airportService.findAllAirport());
        model.addAttribute("planes", aircraftService.findAllAircrafts());
        return "pages/app/flights/new-flight";
    }

}
