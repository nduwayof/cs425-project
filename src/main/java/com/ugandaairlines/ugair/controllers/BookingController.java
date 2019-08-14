package com.ugandaairlines.ugair.controllers;

import com.ugandaairlines.ugair.airport.model.Airport;
import com.ugandaairlines.ugair.airport.service.IAirportService;
import com.ugandaairlines.ugair.booking.service.IBookingService;
import com.ugandaairlines.ugair.flight.model.Flight;
import com.ugandaairlines.ugair.flight.service.IFlightService;
import groovy.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class BookingController {

    Logger logger = Logger.getLogger(BookingController.class.getName() );

    @Autowired
    private IBookingService bookingService;
    @Autowired
    private IFlightService flightService;
    @Autowired
    private IAirportService airportService;

   @GetMapping(path = {"/booking/flight/search"})
   public String bookingFlightSearchResults(@RequestParam Map<String , String> reqParams, Model model){
       Airport departureAirport = airportService.findAirportById(new Integer(reqParams.get("departureAirport")));
       Airport arrivalAirport = airportService.findAirportById(new Integer(reqParams.get("arrivalAirport")));
       LocalDateTime departureDate = LocalDateTime.of(LocalDate.parse(reqParams.get("departureDate")), LocalTime.now());
       LocalDateTime arrivalDate =      LocalDateTime.of(LocalDate.parse(reqParams.get("arrivalDate")), LocalTime.now());
       List<Flight> flights = (List<Flight>)flightService.flightBookingSearch(departureAirport,arrivalAirport,departureDate,arrivalDate);


        logger.log(Level.SEVERE,"cvbb"+ flights.toString());
        model.addAttribute("flights",flights);
        model.addAttribute("totalResults",flights.size());
        model.addAttribute("destination",arrivalAirport);

        return "pages/web/search-flights";

    }
}
