package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping
    public List<Whisky> getAllWhiskies(){return whiskyRepository.findAll();}

    @GetMapping(value = "/year/{year}")
    public List<Whisky>findWhiskyByYear(@PathVariable int year){
        return whiskyRepository.findWhiskyByYear(year);
    }

    @GetMapping(value = "/distillery/{distilleryID}/{age}")
    public List<Whisky>findWhiskyByDistilleryIdAndAge(@PathVariable Long distilleryID, @PathVariable int age){
        return whiskyRepository.findWhiskyByDistilleryIdAndAge(distilleryID,age);
    }

    @GetMapping( "/region/{region}")
    public List<Whisky>findAllWhiskyFromRegion(@PathVariable String region){
        return whiskyRepository.findAllWhiskyFromRegion(region);
    }



}
