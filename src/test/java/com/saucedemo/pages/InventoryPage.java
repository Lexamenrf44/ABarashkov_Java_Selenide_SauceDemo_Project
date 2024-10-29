package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class InventoryPage {

    /* LOCATORS */

    // Common
    private final SelenideElement
            inventoryContainer = $("[data-test='inventory-container']");


    /* METHODS */

    public InventoryPage successfulAuth () {
        inventoryContainer
                .shouldBe(visible);

        return this;
    }
}
