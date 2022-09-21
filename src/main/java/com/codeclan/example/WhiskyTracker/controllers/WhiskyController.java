package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;


    @GetMapping(value = "/whisky")
    public ResponseEntity<List<Whisky>> getAllWhiskys(){
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whisky/byYear")
    public ResponseEntity<List<Whisky>> getWhiskyByYear(@RequestParam(name="year") int year){
        return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
    }

    @GetMapping(value = "/whisky/byDistilleryAndAge")
    public ResponseEntity<List<Whisky>> getWhiskyByDistilleryAndAge(@RequestParam(name="name") String name, @RequestParam(name="age") int age){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryNameAndAge(name,age), HttpStatus.OK);
    }

    @GetMapping(value = "/whisky/byRegion")
    public ResponseEntity<List<Whisky>> getALlWhiskyInRegion(@RequestParam(name="region") String region){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
    }

}
