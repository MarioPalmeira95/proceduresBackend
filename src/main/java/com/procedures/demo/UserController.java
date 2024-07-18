package com.procedures.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {
    
    private static final String template = "Hello, %s!";
	private AtomicLong counter = new AtomicLong();
    
    @GetMapping("/user")
    public User user(@RequestParam(value="name", defaultValue="Mário") String name) {
        return new User(counter.incrementAndGet(), String.format(template, name));
    }
}
