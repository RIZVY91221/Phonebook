package com.example.rizvyahmed.phonebook;

public class ContactHolder {
    public int id;
    public String name,phone;

    public ContactHolder(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public ContactHolder(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
