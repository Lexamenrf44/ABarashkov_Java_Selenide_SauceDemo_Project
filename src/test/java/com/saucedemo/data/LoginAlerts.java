package com.saucedemo.data;

public enum LoginAlerts {

    INVALID_USERNAME_ALERT("Epic sadface: Username is required"),
    INVALID_PASSWORD_ALERT("Epic sadface: Password is required"),
    INVALID_USERNAME_AND_PASSWORD_ALERT("Epic sadface: Username and password do not match any user in this service"),
    LOCKED_OUT_USER_ALERT("Epic sadface: Sorry, this user has been locked out.");

    private final String messagePattern;

    LoginAlerts(String messagePattern) {
        this.messagePattern = messagePattern;
    }

    public String getMessagePattern() {
        return messagePattern;
    }
}
