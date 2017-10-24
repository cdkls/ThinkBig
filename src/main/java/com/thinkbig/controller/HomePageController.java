package com.thinkbig.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
    
   @RequestMapping(value ="/welcome", method = RequestMethod.GET)
    public String welcomeMessage(){
        return "Think Big";
    }
    
   

}
