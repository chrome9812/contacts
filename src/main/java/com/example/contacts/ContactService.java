package com.example.contacts;

import java.util.List;

public interface ContactService {

    public List<Contact> getAllContacts();

    public boolean postContact();

    public List<Contact> findByName(String name);
}
