package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @Autowired(required = false)
    @Qualifier("colorRed")
    private String colorRed;

    @Autowired(required = false)
    @Qualifier("colorBlue")
    private String colorBlue;

    @RequestMapping("/home/{color}")
    public String home(Model page,
                       @RequestParam(required = false, defaultValue = "") String name,
                       @RequestParam(defaultValue = "16") int temperature,
                       @PathVariable String color) {
        page.addAttribute("username", name);
        page.addAttribute("temperature", temperature);
        page.addAttribute("color", color);
        page.addAttribute("colorRed", colorRed != null ? colorRed : "black");
        page.addAttribute("colorBlue", colorBlue != null ? colorBlue : "black");
        return "home.html";
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public String handleMissingPathVariableException() {
        return "redirect:/error";
    }

}
