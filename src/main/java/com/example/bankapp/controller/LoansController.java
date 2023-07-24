package com.example.bankapp.controller;

import com.example.bankapp.model.Loans;
import com.example.bankapp.repository.LoanRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    private LoanRepository loanRepository;

    public LoansController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @GetMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestParam int id){
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        return loans;
    }
}
