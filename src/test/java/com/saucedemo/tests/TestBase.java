package com.saucedemo.tests;

import com.codeborne.selenide.Configuration;
import com.saucedemo.jupiter.BrowserExtension;
import com.saucedemo.web.pages.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Browsers.FIREFOX;

@ExtendWith(BrowserExtension.class)
public class TestBase {

    protected final LoginPage loginPage = new LoginPage();
    protected final InventoryPage inventoryPage = new InventoryPage();
    protected final ItemsPage itemsPage = new ItemsPage();
    protected final CartPage cartPage = new CartPage();
    protected final CheckoutPage checkoutPage = new CheckoutPage();

    @BeforeAll
    static void browserOpeningConfiguration() {

        Configuration.baseUrl = "https://www.saucedemo.com/";
        Configuration.browserSize = "1440x900";
        Configuration.browser = FIREFOX;
        Configuration.headless = false;
    }

}
