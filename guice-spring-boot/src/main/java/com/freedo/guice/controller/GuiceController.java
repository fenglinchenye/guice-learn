package com.freedo.guice.controller;

import com.freedo.guice.greeting.GreetingHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GuiceController {

    private final GreetingHandler greetingHandler;

    @GetMapping("/greeting")
    public String home(@RequestParam("name")String name){
        return greetingHandler.getByName(name);
    }
}
