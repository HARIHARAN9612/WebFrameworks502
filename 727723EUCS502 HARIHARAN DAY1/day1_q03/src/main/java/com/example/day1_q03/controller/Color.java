package com.example.day1_q03.controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/get")
public class Color {
    @GetMapping("/color")
    public String answerfor3 (@RequestParam (required = false) String color)
    {
     return "color "+color;
    }
}
