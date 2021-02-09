package xyz.junral.spring.cloud.weather.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello Controller.
 * @author Junral
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World! Welcome to visit junral.xyz!";
    }

}
