package com.saucedemo.tests;

import com.saucedemo.data.Username;
import com.saucedemo.data.Password;
import com.saucedemo.support.TestBase;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class InvalidAuthTest extends TestBase {

    @Test
    @DisplayName("Sauce Demo")
    void loginToSauceDemo() {
        open("");
        loginPage
                .invalidAuth(Username.locked_out_user, Password.secret_sauce)
                .lockedOutUserAssertion();
    }
}
