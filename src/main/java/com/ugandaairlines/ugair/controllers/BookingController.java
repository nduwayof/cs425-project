package com.ugandaairlines.ugair.controllers;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.ugandaairlines.ugair.airport.model.Airport;
import com.ugandaairlines.ugair.airport.service.IAirportService;
import com.ugandaairlines.ugair.booking.model.Booking;
import com.ugandaairlines.ugair.booking.model.EBookingStatus;
import com.ugandaairlines.ugair.booking.model.Payment;
import com.ugandaairlines.ugair.booking.service.IBookingService;
import com.ugandaairlines.ugair.booking.service.IPaymentService;
import com.ugandaairlines.ugair.config.smtp.IMailService;
import com.ugandaairlines.ugair.config.smtp.implementation.MailMessageTemplate;
import com.ugandaairlines.ugair.flight.model.Flight;
import com.ugandaairlines.ugair.flight.service.IFlightService;
import com.ugandaairlines.ugair.person.model.Customer;
import com.ugandaairlines.ugair.person.model.Passenger;
import com.ugandaairlines.ugair.person.model.Person;
import com.ugandaairlines.ugair.person.service.IPassengerService;
import com.ugandaairlines.ugair.person.service.IPersonService;
import groovy.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
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

    private Logger logger = Logger.getLogger(BookingController.class.getName());

    private IBookingService bookingService;

    private IFlightService flightService;

    private IAirportService airportService;

    private IPassengerService passengerService;

    private IPaymentService paymentService;

    private IMailService mailService;

    @Autowired
    public BookingController(IBookingService bookingService, IFlightService flightService,
                             IAirportService airportService, IPassengerService passengerService,
                             IPaymentService paymentService, IMailService mailService) {
        this.logger = logger;
        this.bookingService = bookingService;
        this.flightService = flightService;
        this.airportService = airportService;
        this.passengerService = passengerService;
        this.paymentService = paymentService;
        this.mailService = mailService;
    }


    @GetMapping(path = {"/booking/flight/search"})
    public String bookingFlightSearchResults(@RequestParam Map<String, String> reqParams, Model model) {
        Airport departureAirport = airportService.findAirportById(new Integer(reqParams.get("departureAirport")));
        Airport arrivalAirport = airportService.findAirportById(new Integer(reqParams.get("arrivalAirport")));
        LocalDateTime departureDate = LocalDateTime.of(LocalDate.parse(reqParams.get("departureDate")), LocalTime.now());
        LocalDateTime arrivalDate = LocalDateTime.of(LocalDate.parse(reqParams.get("arrivalDate")), LocalTime.now());
        List<Flight> flights = (List<Flight>) flightService.flightBookingSearch(departureAirport, arrivalAirport, departureDate, arrivalDate);


        logger.log(Level.INFO, ">>>>>>> " + flights.toString());
        model.addAttribute("flights", flights);
        model.addAttribute("totalResults", flights.size());
        model.addAttribute("destination", arrivalAirport);

        return "pages/web/search-flights";

    }

    @GetMapping(path = "/booking/flight/details")
    public String bookingFlightDetails(@RequestParam("rf") Integer flightId, Model model) {
        Customer customer = new Customer();
        Flight flight = flightService.findFlightById(flightId);
        logger.log(Level.INFO, ">>>>>>> cvbb" + flight);
        model.addAttribute("flight", flight);
        model.addAttribute("customer", customer);
        return "pages/web/booking-details";
    }

    @GetMapping(path = {"/booking/flight/details/new"})
    public String saveBooking(@Valid @RequestAttribute("booking") Booking booking, BindingResult bindingResult, Model model) {
        bookingService.saveBooking(booking);
        return null;
    }

    @GetMapping(path = {"/booking/flight/details/passenger/add"})
    public String addPassengerToBooking(@RequestParam Map<String, String> reqParam, @Valid @ModelAttribute("passenger") Passenger passenger, Model model, BindingResult bindingResult) {
        Passenger passenger2 = passengerService.savePassenger(passenger);
        Integer flightId = new Integer(reqParam.get("flight"));
        Integer bookingId = new Integer(reqParam.get("booking"));
        return "redirect:/booking/flight/passenger?rf=" + flightId + "&bk=" + bookingId + "&addMeAsPassenger=No";
    }

    @GetMapping(path = {"/booking/flight/details/customer/new"})
    public String setBookingCustomer(@RequestParam("addMeAsPassenger") String addMeAsPassenger, @Valid @ModelAttribute("customer") Customer customer, @RequestParam("rf") Integer flightId, Model model) {
        Flight flight = flightService.findFlightById(flightId);
        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setBookingStatus(EBookingStatus.PENDING);
        booking.setCustomer(customer);
        Booking booking2 = bookingService.saveBooking(booking);

        model.addAttribute("booking", booking);
        model.addAttribute("passenger", new Passenger());
        model.addAttribute("flight", flight);
        if (addMeAsPassenger.equals("Yes")) {
            model.addAttribute("cusomer", customer);
        }

        logger.log(Level.INFO, ">>>>>>> " + booking2);
        return "redirect:/booking/flight/passenger?rf=" + flight.getFlightId() + "&bk=" + booking2.getBookingId() + "&addMeAsPassenger=" + addMeAsPassenger;
    }

    @GetMapping(path = "/booking/flight/passenger")
    public String bookingFlightPassenger(@RequestParam Map<String, String> reqParam, Model model) {
        Customer customer = new Customer();
        Integer flightId = new Integer(reqParam.get("rf"));
        Integer bookingId = new Integer(reqParam.get("bk"));
        String addMeAsPassenger = reqParam.get("addMeAsPassenger");
        Flight flight = flightService.findFlightById(flightId);
        Booking booking = bookingService.findBookingById(bookingId);
        List<Passenger> passengers = (List<Passenger>) passengerService.findPassegersByBooking(booking);
        booking.setPassengers(passengers);
        logger.log(Level.INFO, ">>>>>>> " + passengers);
        model.addAttribute("flight", flight);
        model.addAttribute("passenger", new Passenger());
        model.addAttribute("booking", booking);
        if (addMeAsPassenger.equals("Yes")) {
            customer = booking.getCustomer();
        }
        Double totalCost = bookingService.calculateTotalCost(booking);
        booking.setBookingCost(totalCost);
        bookingService.saveBooking(booking);
        model.addAttribute("customer", customer);
        model.addAttribute("passengers", passengers);
        model.addAttribute("totalCost", totalCost);

        return "pages/web/booking-add-passenger";
    }


//    Controller to manage payments


    @GetMapping(path = "/booking/flight/payment")
    public ModelAndView payment(@RequestParam("bookingId") Integer bookingId, @RequestParam("amount") Double amount) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("bookingId", bookingId);
        modelAndView.addObject("amount", amount);

        modelAndView.setViewName("pages/web/payment-page");
        return modelAndView;
    }

    @GetMapping(path = "/customer/payment/paypal")
    public String Dposit(@RequestParam("bookingId") Integer bookingId, @RequestParam("amount") Double amount) {
        Booking booking = bookingService.findBookingById(bookingId);
        booking.setBookingStatus(EBookingStatus.COMPLETE);
        bookingService.saveBooking(booking);
        Payment payment = new Payment("PayPalOrCard", booking, amount);
        paymentService.savePayment(payment);
        try {
            List<Passenger> passengers = (List<Passenger>) passengerService.findPassegersByBooking(booking);
            for (Passenger passenger : passengers) {
                mailService.sendMailUsingTemplate(
                        passenger.getEmail(),
                        "nduwayof@icloud.com",
                        "Booking Confirmation",
                        new MailMessageTemplate().BookingConfirmation(passenger)
                );
            }
        }catch (Exception ex){
            logger.log(Level.SEVERE, "Unable to send email");
        }
        return "pages/web/payment-successful-page";
    }


}
