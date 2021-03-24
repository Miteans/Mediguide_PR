package com.example.trial1;

public class User {
    private String Name;
    private String Email;
    private Long Phonenumber;
    private String Password;

    public User() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}


