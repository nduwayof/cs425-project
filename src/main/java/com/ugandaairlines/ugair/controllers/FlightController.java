package com.ugandaairlines.ugair.controllers;

import com.ugandaairlines.ugair.airport.model.Airport;
import com.ugandaairlines.ugair.airport.service.IAircraftService;
import com.ugandaairlines.ugair.airport.service.IAirportService;
import com.ugandaairlines.ugair.flight.model.Flight;
import com.ugandaairlines.ugair.flight.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FlightController {


    private IAirportService airportService;
    private IAircraftService aircraftService;
    private IFlightService flightService;

    @Autowired
    public FlightController(IAirportService airportService,
                            IAircraftService aircraftService,
                            IFlightService flightService) {
        this.airportService = airportService;
        this.aircraftService = aircraftService;
        this.flightService = flightService;
    }

    @GetMapping(path = "/app/flight/new")
    public String addNewFlight(Model model) {
        model.addAttribute("flight", new Flight());
        Iterable<Airport> airports = airportService.findAllAirport();
        model.addAttribute("airports", airports);
        return "pages/app/flights/new-flight";
    }

    @GetMapping(path = "/app/flights/save")
    private String saveFlight(@ModelAttribute Flight flight) {
        flightService.saveFlight(flight);
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

    @GetMapping(path = "/app/flights")
    public ModelAndView customerList(@RequestParam(defaultValue = "0") int pageNo) {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<Flight> flights = flightService.findAllFlights();
        //long numberOfCustomers = flights.getTotalElements();
        modelAndView.addObject("currPageNo", pageNo);
        modelAndView.addObject("flights", flights);
        modelAndView.setViewName("pages/app/flights/flights");
        return modelAndView;
    }

}
