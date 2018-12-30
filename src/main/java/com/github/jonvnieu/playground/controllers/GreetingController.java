package com.github.jonvnieu.playground.controllers;

import com.github.jonvnieu.playground.resources.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello %s!";

    private final AtomicLong counter;

    public GreetingController() {
        this.counter = new AtomicLong();
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting getGreeting(@RequestParam(name = "name", defaultValue = "World") String name) {
        return new Greeting(counter.getAndIncrement(), String.format(TEMPLATE, name));
    }
}
