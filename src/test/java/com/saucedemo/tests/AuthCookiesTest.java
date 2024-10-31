package com.saucedemo.tests;

import com.saucedemo.jupiter.CookieLogin;
import com.saucedemo.support.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class AuthCookiesTest extends TestBase {

    @CookieLogin
    @Test
    @DisplayName("Should authorize via cookies")
    void loginWithCookies() {

        sleep(10000);
    }
}
