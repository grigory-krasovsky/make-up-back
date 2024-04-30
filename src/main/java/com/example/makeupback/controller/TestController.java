package com.example.makeupback.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestController {
    @GetMapping
    public String test() {
        return "Hello world";
    }
}