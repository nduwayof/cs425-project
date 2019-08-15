package com.ugandaairlines.ugair.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @GetMapping(path = "/administrator/login")
    public String login(){
        return "pages/login";
    }

    @GetMapping(path = "/app/dashboard")
    public String dashboard(){
        return "pages/app/dashboard";
    }

}
