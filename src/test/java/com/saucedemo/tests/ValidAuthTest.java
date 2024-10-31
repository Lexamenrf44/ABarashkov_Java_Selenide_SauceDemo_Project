package com.saucedemo.tests;

import com.saucedemo.data.Password;
import com.saucedemo.data.Username;
import com.saucedemo.jupiter.CookieLogin;
import com.saucedemo.support.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class ValidAuthTest extends TestBase {

    @Test
    @DisplayName("Should authorize with valid credentials")
    void loginWithInvalidCredentials() {
        open("");
        loginPage.doLogin(Username.standard_user, Password.secret_sauce);
        inventoryPage.waitUntilLoaded();
    }

    @CookieLogin(cookieLifeTimeInSeconds = 3)
    @Test
    @DisplayName("Should logout after 3 seconds")
    void logoutAfter3Seconds() {
        inventoryPage.waitUntilLoaded();
        sleep(5000);
        refresh();
        sleep(5000);
    }
}
