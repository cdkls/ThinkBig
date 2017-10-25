package com.thinkbig.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
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
    
    @RequestMapping(value ="/categories", method = RequestMethod.GET)
    public ResponseEntity<List<ThinkBig>> getCategories(){
        ThinkBig thinkBig=new ThinkBig();
        thinkBig.setName("Categories");
        List<ThinkBig> hellos=new ArrayList<>();
        hellos.add(thinkBig);
        return new ResponseEntity<List<ThinkBig>>(hellos, HttpStatus.OK);
    }
    
    @RequestMapping(value ="/products", method = RequestMethod.GET)
    public ResponseEntity<List<ThinkBig>> getProducts(){
        ThinkBig thinkBig=new ThinkBig();
        thinkBig.setName("Products");
        List<ThinkBig> hellos=new ArrayList<>();
        hellos.add(thinkBig);
        return new ResponseEntity<List<ThinkBig>>(hellos, HttpStatus.OK);
    }
    
   

}
