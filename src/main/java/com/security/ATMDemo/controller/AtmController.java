package com.security.ATMDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Liviu
 */

@Controller
public class AtmController {

    private static final Logger log =
            LoggerFactory.getLogger(AtmController.class);

    // add request mapping for "/loginPage"
    @GetMapping("/loginPage")
    public String showLoginPage() {
        log.info("===Showing the loginPage");
        return "loginPage";
    }

    // add request mapping for "/access-denied"
    @GetMapping("/access-denied")
    public String showAccessDenied() {
        log.info("===Showing the access-denied page");
        return "access-denied";
    }

    // add request mapping for "/"  (accountPage)
    @GetMapping("/")
    public String showAccountPage() {
        log.info("===Showing the accountPage");
        return "accountPage";
    }
}
