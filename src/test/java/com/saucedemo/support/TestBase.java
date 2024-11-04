package com.saucedemo.support;

import com.codeborne.selenide.Configuration;
import com.saucedemo.jupiter.BrowserExtension;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BrowserExtension.class)
public class TestBase {

    protected final LoginPage loginPage = new LoginPage();
    protected final InventoryPage inventoryPage = new InventoryPage();

    @BeforeAll
    static void browserOpeningConfiguration() {

        Configuration.baseUrl = "https://www.saucedemo.com/";
        Configuration.browserSize = "1920x1080";
    }

}
