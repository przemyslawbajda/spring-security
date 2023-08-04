package com.example.bankapp.controller;

import com.example.bankapp.model.Customer;
import com.example.bankapp.model.Loans;
import com.example.bankapp.repository.CustomerRepository;
import com.example.bankapp.repository.LoanRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    private LoanRepository loanRepository;
    private CustomerRepository customerRepository;

    public LoansController(LoanRepository loanRepository, CustomerRepository customerRepository) {
        this.loanRepository = loanRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestParam String email){
        List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customers.get(0).getId());
            if (loans != null ) {
                return loans;
            }
        }
        return null;
    }
}
