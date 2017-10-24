package com.thinkbig.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value ="/welcome", method = RequestMethod.GET)
    public ResponseEntity<List<Helo>> welcomeMessage(){
        Helo helo=new Helo();
        helo.setName("Thing Big");
        List<Helo> hellos=new ArrayList<>();
        hellos.add(helo);
        return new ResponseEntity<List<Helo>>(hellos, HttpStatus.OK);
    }
    
   

}
