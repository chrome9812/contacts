package com.example.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    //Not implemented
    @Override
    public List<Contact> getAllContacts() {
        return null;
    }

    //Not implemented
    @Override
    public boolean postContact() {
        return false;
    }

    @Override
    public List<Contact> findByName(String name) {
        //Testing save option
         contactRepository.getCouchbaseOperations().save(new Contact(name,null,"38438745457","lll","ooo"));
        return contactRepository.findByName(name);
    }
}
