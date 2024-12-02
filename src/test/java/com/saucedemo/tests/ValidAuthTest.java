package com.saucedemo.tests;

import com.saucedemo.data.Password;
import com.saucedemo.data.Username;
import com.saucedemo.jupiter.CookieLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidAuthTest extends TestBase {

    @Test
    @DisplayName("Should authorize with valid credentials")
    void loginWithValidCredentials() {
        loginPage.doLogin(Username.standard_user, Password.secret_sauce);
    }

    @CookieLogin
    @Test
    @DisplayName("Should logout via UI")
    void logoutViaBurgerMenu() {
        inventoryPage.doLogout();
    }
}
