package com.example.AttPontuada1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev")
public class Dev {
    @GetMapping
    public String Dev() {
        return "Desenvolvedor: Luís Felipe";
    }
}
