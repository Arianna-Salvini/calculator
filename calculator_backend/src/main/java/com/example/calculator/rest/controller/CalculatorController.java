package com.example.calculator.rest.controller;

import com.example.calculator.rest.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //mark this class as a REST controller, where methods return data (like JSON) instead of views.
@RequestMapping("api/calculator") //define the base path of all operations
@CrossOrigin

public class CalculatorController {

    @Autowired // injection of CalculatorService into the controller, allows the use of its methods for mathematical operation
    private CalculatorService calculatorService;

    // Handle GET request for sum
    @GetMapping("/sum")   //Associate a URL and Http Get request with the logic methods
    public int sum(@RequestParam int a, @RequestParam int b){   //capture query parameters from URL and pass them as methods parameters
        // Call method sum of calculatorService and return the result
        return calculatorService.sum(a, b);
    }

    // Handle GET request for subtraction
    @GetMapping("/sub")
    public int sub(@RequestParam int a, @RequestParam int b){
        return calculatorService.subtraction(a, b);
    }

    // Handle GET request for multiplication
    @GetMapping("/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b){
        return calculatorService.multiplication(a, b);
    }

    // Handle GET request for division
    @GetMapping("/div")
    public int div(@RequestParam int a, @RequestParam int b){
        return calculatorService.division(a, b);
    }
}
