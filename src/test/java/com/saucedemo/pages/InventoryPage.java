package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class InventoryPage extends BasePage<InventoryPage> {

    private final SelenideElement
            inventoryContainer = $("[data-test='inventory-container']");

    @Override
    public InventoryPage checkThatPageLoaded() {
        return null;
    }

    public InventoryPage waitUntilInventoryContainerVisible() {
        inventoryContainer.shouldBe(visible);
        return this;
    }
}
