package com.ifi.trainer_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    // TODO
    @PostMapping("/registerTrainer")
    ModelAndView registerNewTrainer(String trainerName){
        var modelAndView = new ModelAndView("register");
        modelAndView.addObject("name",trainerName);
        return modelAndView;
        // TODO
    }

}

