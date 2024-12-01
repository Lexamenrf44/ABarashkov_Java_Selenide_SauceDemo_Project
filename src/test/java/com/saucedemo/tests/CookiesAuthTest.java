package com.saucedemo.tests;

import com.saucedemo.data.LogoutAlerts;
import com.saucedemo.jupiter.CookieLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CookiesAuthTest extends TestBase {

    @CookieLogin
    @Test
    @DisplayName("Should authorize with cookies")
    void shouldAuthorizeWithCookies() {
        inventoryPage.checkThatPageLoaded();
    }

    @CookieLogin(cookieLifeTimeInSeconds = 3)
    @Test
    @DisplayName("Should logout after cookies spoiled in 3 seconds on [Refresh]")
    void loggedOutAfterCookiesSpoiled() {
        inventoryPage.logoutOnRefreshAfterCookiesSpoiled();
        loginPage.loggedOutUserAssertion(LogoutAlerts.INVENTORY_PAGE_ALERT);
    }

    @CookieLogin(cookieLifeTimeInSeconds = 60)
    @Test
    @DisplayName("Should logout after manually clearing cookies on [Refresh]")
    void loggedOutAfterClearingCookiesManually() {
        inventoryPage.logoutOnRefreshAfterManuallyClearingCookies();
        loginPage.loggedOutUserAssertion(LogoutAlerts.INVENTORY_PAGE_ALERT);
    }
}
