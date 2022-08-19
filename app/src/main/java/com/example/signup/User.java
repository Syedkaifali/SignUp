package com.example.signup;


import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    private String date;
    private String bp;
    private String notes;

    public User() {
    }

    public User(String date, String bp, String notes) {
        this.date = date;
        this.bp = bp;
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public String getBp() {
        return bp;
    }

    public String getNotes() {
        return notes;
    }
}
