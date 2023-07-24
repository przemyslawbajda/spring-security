package com.example.bankapp.controller;

import com.example.bankapp.model.Contact;
import com.example.bankapp.repository.ContactRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Random;

@RestController
public class ContactController {

    private ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping("/contact")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact){

        contact.setContactId(getServiceRequestNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return contactRepository.save(contact);
    }

    public String getServiceRequestNumber(){
        Random random = new Random();
        int randomNumber = random.nextInt(999999999 - 9999)+9999;
        return "SR" + randomNumber;
    }
}
