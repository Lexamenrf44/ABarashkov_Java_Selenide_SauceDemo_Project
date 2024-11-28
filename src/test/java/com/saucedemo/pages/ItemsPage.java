package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import com.saucedemo.utils.ScreenshotUtils;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ItemsPage extends BasePage<ItemsPage> {

    private final SelenideElement
            inventoryItemContainer = $("[data-test='inventory-container']"),
            backpackItemImage = $("[data-test='item-sauce-labs-backpack-img']"),
            bikeLightItemImage = $("[data-test='item-sauce-labs-bike-light-img']"),
            boltTShirtItemImage = $("[data-test='item-sauce-labs-bolt-t-shirt-img']"),
            fleeceJacketItemImage = $("[data-test='item-sauce-labs-fleece-jacket-img']"),
            onesieItemImage = $("[data-test='item-sauce-labs-onesie-img']"),
            redJumperItemImage = $("[data-test='item-test.allthethings()-t-shirt-(red)-img']");

    @Override
    public InventoryPage checkThatPageLoaded() {
        return null;
    }

    public ItemsPage waitUntilInventoryContainerVisible() {
        inventoryItemContainer.shouldBe(visible);
        return this;
    }

    public ItemsPage assertBackpackItemImage() throws IOException {
        ScreenshotUtils.verifyScreenshot(backpackItemImage);
        manuallyClearCookies();
        return this;
    }

    public ItemsPage assertBikeLightItemImage() throws IOException {
        ScreenshotUtils.verifyScreenshot(bikeLightItemImage);
        manuallyClearCookies();
        return this;
    }

    public ItemsPage assertBoltTShirtItemImage() throws IOException {
        ScreenshotUtils.verifyScreenshot(boltTShirtItemImage);
        manuallyClearCookies();
        return this;
    }

    public ItemsPage assertFleeceJacketItemImage() throws IOException {
        ScreenshotUtils.verifyScreenshot(fleeceJacketItemImage);
        manuallyClearCookies();
        return this;
    }

    public ItemsPage assertOnesieItemImage() throws IOException {
        ScreenshotUtils.verifyScreenshot(onesieItemImage);
        manuallyClearCookies();
        return this;
    }

    public ItemsPage assertRedJumperItemImage() throws IOException {
        ScreenshotUtils.verifyScreenshot(redJumperItemImage);
        manuallyClearCookies();
        return this;
    }
}
