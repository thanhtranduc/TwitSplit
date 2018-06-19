package com.thanh.twitsplit.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * MessageTwit Entity used in the data layer.
 */
public class MessageEntity {

    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
