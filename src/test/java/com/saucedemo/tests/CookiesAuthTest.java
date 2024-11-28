package com.saucedemo.tests;

import com.saucedemo.data.LogoutAlerts;
import com.saucedemo.jupiter.CookieLogin;
import com.saucedemo.pages.BasePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;

public class CookiesAuthTest extends TestBase {

    @CookieLogin(cookieLifeTimeInSeconds = 3)
    @Test
    @DisplayName("Should logout after cookies spoiled in 3 seconds on [Refresh]")
    void loggedOutAfterCookiesSpoiled() {
        inventoryPage.waitUntilInventoryContainerVisible();
        sleep(3500);
        refresh();
        loginPage.loggedOutUserAssertion(LogoutAlerts.INVENTORY_PAGE_ALERT);
    }

    @CookieLogin(cookieLifeTimeInSeconds = 60)
    @Test
    @DisplayName("Should logout after manually clearing cookies on [Refresh]")
    void loggedOutAfterClearingCookiesManually() {
        inventoryPage.waitUntilInventoryContainerVisible();
        refresh();
        loginPage.loggedOutUserAssertion(LogoutAlerts.INVENTORY_PAGE_ALERT);
    }
}
