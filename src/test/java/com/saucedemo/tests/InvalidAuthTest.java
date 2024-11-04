package com.saucedemo.tests;

import com.saucedemo.data.Password;
import com.saucedemo.data.Username;
import com.saucedemo.support.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class InvalidAuthTest extends TestBase {

    @Test
    @DisplayName("Should not authorize with invalid credentials")
    void loginWithInvalidCredentials() {
        open("");
        loginPage
                .doLogin(Username.locked_out_user, Password.secret_sauce)
                .lockedOutUserAssertion();
    }

    @Test
    @DisplayName("Should not authorize without credentials")
    void loginWithoutCredentials() {
        loginPage
                .setEmptyAuthFields()
                .emptyUserAssertion();
    }
}
