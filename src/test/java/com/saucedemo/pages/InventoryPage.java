package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public class InventoryPage {

    /* LOCATORS */

    // Common
    private final SelenideElement
            inventoryContainer = $("[data-test='inventory-container']");


    /* METHODS */

    public InventoryPage waitUntilInventoryContainerVisible() {
        inventoryContainer
                .shouldBe(visible);

        return this;
    }

    public InventoryPage manuallyClearCookies() {
        clearBrowserCookies();

        return this;
    }
}
