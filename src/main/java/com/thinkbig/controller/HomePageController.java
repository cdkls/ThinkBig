package com.thinkbig.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
    
    @RequestMapping(value ="/welcome", method = RequestMethod.GET)
    public ResponseEntity<List<ThinkBig>> welcomeMessage(){
        ThinkBig thinkBig=new ThinkBig();
        thinkBig.setName("Welcome To ThinkBig");
        List<ThinkBig> hellos=new ArrayList<>();
        hellos.add(thinkBig);
        return new ResponseEntity<List<ThinkBig>>(hellos, HttpStatus.OK);
    }
}
