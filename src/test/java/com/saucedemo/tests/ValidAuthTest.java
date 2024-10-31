package com.saucedemo.tests;

import com.saucedemo.data.Username;
import com.saucedemo.data.Password;
import com.saucedemo.support.TestBase;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class ValidAuthTest extends TestBase {

    @Test
    @DisplayName("Should authorize with valid credentials")
    void loginWithInvalidCredentials() {
        open("");
        loginPage.doLogin(Username.standard_user, Password.secret_sauce);
        inventoryPage.waitUntilLoaded();
    }
}
