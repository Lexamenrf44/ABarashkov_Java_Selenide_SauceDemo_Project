package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import com.saucedemo.data.LoginAlerts;
import com.saucedemo.data.LogoutAlerts;
import com.saucedemo.data.Password;
import com.saucedemo.data.Username;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    // Тесты должны быть потокобезопасными (узнать больше), потому что запускаются в многопотоке

    /* LOCATORS */

    // Common
    private final SelenideElement
            title = $(withText("Swag Labs")),
            errorLabel = $("h3[data-test='error']");

    // Buttons
    private final SelenideElement
            loginButton = $("[data-test='login-button']");

    // Fields
    private final SelenideElement
            loginField = $("[data-test='username']"),
            passwordField = $("[data-test='password']");

    /* METHODS */

    public LoginPage doLogin(Username username, Password password) {
        loginField.setValue(username.name());
        passwordField.setValue(password.name());
        loginButton.click();

        return this;
    }

    public LoginPage setAuthFieldsManually(String username, String password) {
        loginField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();

        return this;
    }

    public LoginPage invalidUserAuthorisationAssertion(LoginAlerts alert) {
        errorLabel.shouldHave(text(alert.getMessagePattern()));
        loginField.shouldHave(cssClass("error"));
        passwordField.shouldHave(cssClass("error"));

        return this;
    }

    public LoginPage loggedOutUserAssertion(LogoutAlerts alert) {
        errorLabel.shouldHave(matchText(alert.getMessagePattern()));
        loginField.shouldHave(cssClass("error"));
        passwordField.shouldHave(cssClass("error"));

        return this;
    }
}
