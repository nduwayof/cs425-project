package com.ugandaairlines.ugair.controllers;

import com.ugandaairlines.ugair.airport.model.Aircraft;
import com.ugandaairlines.ugair.airport.model.Airport;
import com.ugandaairlines.ugair.airport.service.IAircraftService;
import com.ugandaairlines.ugair.airport.service.IAirportService;
import com.ugandaairlines.ugair.flight.model.Flight;
import com.ugandaairlines.ugair.flight.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;


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
        Iterable<Aircraft> aircrafts = aircraftService.findAllAircrafts();
        model.addAttribute("airports", airports);
        model.addAttribute("aircrafts", aircrafts);
        return "pages/app/flights/new-flight";
    }

    @PostMapping("/app/flights/save")
    private String saveFlight(@ModelAttribute Flight flight,Model model) {
        String dt = flight.getDepartureHour();
        String at = flight.getArrivalHour();
        int minute  =Integer.parseInt(dt.substring(14,16));
        int hour  =Integer.parseInt(dt.substring(11,13));
        int day  =Integer.parseInt(dt.substring(8,10));
        int month  =Integer.parseInt(dt.substring(5,7));
        int year  =Integer.parseInt(dt.substring(0,4));
        flight.setDepartureTime(LocalDateTime.of(year,month,day,hour,minute));

        minute  =Integer.parseInt(at.substring(14,16));
        hour  =Integer.parseInt(at.substring(11,13));
        day  =Integer.parseInt(at.substring(8,10));
        month  =Integer.parseInt(at.substring(5,7));
        year  =Integer.parseInt(at.substring(0,4));
        flight.setArrivalTime(LocalDateTime.of(year,month,day,hour,minute));

        Flight f = flightService.saveFlight(flight);
        int id = f.getFlightId();
        String flightNo = "UG" +String.format("%04d" , id);
        f.setFlightNumber(flightNo);
        flightService.saveFlight(f);
        return "redirect:/app/flights";
    }

    @RequestMapping("/app/flights/update")
    public String updateFlight(@RequestParam("flightId") Integer flightId,Model model){
        Flight flight =flightService.findFlightById(flightId);
        flight.setDepartureHour(flight.getDepartureTime().toString());
        flight.setArrivalHour(flight.getArrivalTime().toString());
        model.addAttribute("flight",flight);
        Iterable<Airport> airports = airportService.findAllAirport();
        Iterable<Aircraft> aircrafts = aircraftService.findAllAircrafts();
        model.addAttribute("airports", airports);
        model.addAttribute("aircrafts", aircrafts);

        return "pages/app/flights/new-flight";
    }

    @RequestMapping("/app/flights/delete")
    public String deleteCustomer(@RequestParam("flightId") Integer flightId){
        flightService.deleteFlight(flightService.findFlightById(flightId));
        return "redirect:/app/flights";
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
