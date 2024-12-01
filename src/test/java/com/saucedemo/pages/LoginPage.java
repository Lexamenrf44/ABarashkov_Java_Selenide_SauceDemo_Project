package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import com.saucedemo.data.LoginAlerts;
import com.saucedemo.data.LogoutAlerts;
import com.saucedemo.data.Password;
import com.saucedemo.data.Username;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage<LoginPage> {

    private final SelenideElement
            loginContainer = $("[data-test='login-container']"),
            errorLabel = $("h3[data-test='error']"),
            loginButton = $("[data-test='login-button']"),
            loginField = $("[data-test='username']"),
            passwordField = $("[data-test='password']");

    @Override
    @Step("Check that Login Page is visible")
    public LoginPage checkThatPageLoaded() {
        loginContainer.shouldBe(visible);
        return this;
    }

    @Step("Do manual login via UI")
    public InventoryPage doLogin(Username username, Password password) {
        checkThatPageLoaded();
        loginField.setValue(username.name());
        passwordField.setValue(password.name());
        loginButton.click();

        return new InventoryPage().checkThatPageLoaded();
    }
    
    
    
    @Step("Set manually login and password fields and press login button")
    public LoginPage setManuallyAuthFieldsAndPressLogin(String username, String password) {
        loginField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();

        return this;
    }
    
    @Step("Assert invalid user authorisation message")
    public LoginPage invalidUserAuthorisationAssertion(LoginAlerts alert) {
        errorLabel.shouldHave(text(alert.getMessagePattern()));
        loginField.shouldHave(cssClass("error"));
        passwordField.shouldHave(cssClass("error"));

        return this;
    }
    
    @Step("Assert logged out user message")
    public LoginPage loggedOutUserAssertion(LogoutAlerts alert) {
        errorLabel.shouldHave(matchText(alert.getMessagePattern()));
        loginField.shouldHave(cssClass("error"));
        passwordField.shouldHave(cssClass("error"));

        return this;
    }
}
