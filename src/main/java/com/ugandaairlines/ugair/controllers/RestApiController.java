package com.ugandaairlines.ugair.controllers;

import com.ugandaairlines.ugair.flight.model.Flight;
import com.ugandaairlines.ugair.flight.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestApiController {

    private IFlightService flightService;

    public RestApiController(IFlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping(path = "/api/flights")
    public List<Flight> flights(){
        return  (List<Flight>) flightService.findAllFlights();
    }

}
