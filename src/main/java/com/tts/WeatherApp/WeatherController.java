package com.tts.WeatherApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {
    @Autowired
    private WeatherService weatherService;
    
    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("request", new Request());  
        return "index";
    }
    
    //method when you hit submit
    @PostMapping
    public String postIndex(Request request, Model model) {
        //call weather service using the request.zipcode from the data that you saved
    	//lombok does your getters and setters to you
    	Response data = weatherService.getForecast(request.getZipCode());
        //pass data to view. btwn controller and view
    	model.addAttribute("data", data);
        return "index";
        //return index.html from static template. call the view. call out each attribute from response.java into the view aka index
    }
}