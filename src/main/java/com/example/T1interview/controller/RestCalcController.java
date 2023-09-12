package com.example.T1interview.controller;


import com.example.T1interview.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController

public class RestCalcController {
    @Autowired
    private final CalculateService calculateService;


    public RestCalcController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }


    @GetMapping(value = "/api/calculate/{str}")
    @ResponseBody
    public Set<String> calculate(@PathVariable String str){

         return calculateService.calculate(str);
    }

}
