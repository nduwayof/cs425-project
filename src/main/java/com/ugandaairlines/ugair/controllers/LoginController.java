package com.ugandaairlines.ugair.controllers;

import com.ugandaairlines.ugair.security.domain.EUserType;
import com.ugandaairlines.ugair.security.domain.PrincipalDetails;
import com.ugandaairlines.ugair.security.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"currentUser"})
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping(path = {"/login","/administrator/login"})
    public String login() {
        return "pages/login";
    }

    @GetMapping(path = "/login/failed")
    public String loginError(Model model) {
        log.info("Login attempt failed");
        model.addAttribute("error", "true");
        return "login";
    }
    @GetMapping(value = "/logout")
    public String logout(SessionStatus session) {
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();
        return "redirect:/login";
    }

    @PostMapping(value = "/administrator/authenticate")
    public String postLogin(Model model, HttpSession session) {
        log.info("postLogin()");
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        validatePrinciple(authentication.getPrincipal());
        User loggedInUser = ((PrincipalDetails) authentication.getPrincipal()).getUserDetails();
        model.addAttribute("currentUser", loggedInUser.getEmail());
        session.setAttribute("userId", loggedInUser.getId());
        String url = ((loggedInUser.getUserType().equals(EUserType.STAFF) ) ?
                "/app/dashboard" : "/customer/dashboard");
        return "redirect:"+url;
    }

    private void validatePrinciple(Object principal) {
        if (!(principal instanceof PrincipalDetails)) {
            throw new  IllegalArgumentException("Principal can not be null!");
        }
    }

}
