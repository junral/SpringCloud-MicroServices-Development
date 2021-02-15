package xyz.junral.spring.cloud.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello Controller.
 * @author Junral
 */
@RestController
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello() {
    	logger.info("hello world");
        return "Hello World! Welcome to visit junral.xyz!";
    }

}
