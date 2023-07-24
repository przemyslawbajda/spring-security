package com.example.bankapp.controller;

import com.example.bankapp.model.Cards;
import com.example.bankapp.repository.CardsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    private CardsRepository cardsRepository;

    public CardsController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @GetMapping("/myCards")
    public List<Cards> getCardsDetails(@RequestParam int id){
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        return cards;
    }
}
