package com.example.bankapp.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class CardsController {

    @GetMapping("/myCards")
    public String getCardsDetails(){
        return "Here are the card details from the DB";
    }
}
