package com.thanh.twitsplit.presentation.model;

public class TwitMessageModel {

    private String message;

    public TwitMessageModel(String temp) {
        this.message = temp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
