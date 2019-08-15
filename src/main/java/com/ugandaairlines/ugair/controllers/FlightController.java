package com.ugandaairlines.ugair.controllers;

import com.ugandaairlines.ugair.airport.model.Aircraft;
import com.ugandaairlines.ugair.airport.model.Airport;
import com.ugandaairlines.ugair.airport.service.IAircraftService;
import com.ugandaairlines.ugair.airport.service.IAirportService;
import com.ugandaairlines.ugair.booking.model.Booking;
import com.ugandaairlines.ugair.booking.service.IBookingService;
import com.ugandaairlines.ugair.flight.model.Flight;
import com.ugandaairlines.ugair.flight.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    private IBookingService iBookingService;
    @Autowired
    public FlightController(IAirportService airportService,
                            IAircraftService aircraftService,
                            IFlightService flightService,
                            IBookingService iBookingService) {
        this.airportService = airportService;
        this.aircraftService = aircraftService;
        this.flightService = flightService;
        this.iBookingService = iBookingService;
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
    public ModelAndView flightList(@RequestParam(defaultValue = "0") int pageno) {
        ModelAndView modelAndView = new ModelAndView();
        Page<Flight> flights = flightService.findAllFlights(pageno);
        long numberOfFlights = flights.getTotalElements();
        modelAndView.addObject("currPageNo", pageno);
        modelAndView.addObject("flights", flights);
        modelAndView.addObject("flashBack", "/app/flights");
        modelAndView.setViewName("pages/app/flights/flights");
        return modelAndView;
    }

    @GetMapping("/flights/search")
    public ModelAndView search(@RequestParam String search, @RequestParam(defaultValue = "0") int pageno) {
        Page<Flight> flights = flightService.search(search, pageno);
        long numberOfFlights = flights.getTotalElements();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("flights", flights);
        modelAndView.addObject("currPageNo", pageno);
        modelAndView.addObject("numberOfFlights", numberOfFlights);
        modelAndView.addObject("flashBack", "/flights/search?search=" + search);
        modelAndView.setViewName("pages/app/flights/flights");
        return modelAndView;
    }

//    ###################################
//    The code below this line is meant to be moved to Booking controller


    @GetMapping(path = "/app/bookings")
    public ModelAndView bookingList(@RequestParam(defaultValue = "0") int pageno) {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<Booking> bookings = iBookingService.findAllBookings();
        //long numberOfFlights = bookings.getTotalElements();
        modelAndView.addObject("currPageNo", pageno);
        modelAndView.addObject("bookings", bookings);
        modelAndView.addObject("flashBack", "/app/bookings");
        modelAndView.setViewName("pages/app/flights/bookings");
        return modelAndView;
    }

}
