package com.examples.demo.demo_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoProjectApplication {

    @GetMapping("/hello-world")
    public String getCasualWelcomeMessage() {
        return "Hey World...!!!";
    }
    
    @GetMapping("/")
    public String getGenericWelcomeMessage() {
        return "Hello World...!!!";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);
	}

}
