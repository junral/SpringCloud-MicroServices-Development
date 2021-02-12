package xyz.junral.spring.cloud.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World! Welcome to visit junral.xyz!";
    }

}
