package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import com.saucedemo.utils.ScreenshotUtils;

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
    public ItemsPage checkThatPageLoaded() {
        inventoryItemContainer.shouldBe(visible);
        return this;
    }

    public ItemsPage assertBackpackItemImage() {
        backpackItemImage.shouldBe(visible);
        ScreenshotUtils.verifyScreenshot(backpackItemImage);
        return this;
    }

    public ItemsPage assertBikeLightItemImage() {
        bikeLightItemImage.shouldBe(visible);
        ScreenshotUtils.verifyScreenshot(bikeLightItemImage);
        return this;
    }

    public ItemsPage assertBoltTShirtItemImage() {
        boltTShirtItemImage.shouldBe(visible);
        ScreenshotUtils.verifyScreenshot(boltTShirtItemImage);
        return this;
    }

    public ItemsPage assertFleeceJacketItemImage() {
        fleeceJacketItemImage.shouldBe(visible);
        ScreenshotUtils.verifyScreenshot(fleeceJacketItemImage);
        return this;
    }

    public ItemsPage assertOnesieItemImage() {
        onesieItemImage.shouldBe(visible);
        ScreenshotUtils.verifyScreenshot(onesieItemImage);
        return this;
    }

    public ItemsPage assertRedJumperItemImage() {
        redJumperItemImage.shouldBe(visible);
        ScreenshotUtils.verifyScreenshot(redJumperItemImage);
        return this;
    }
}
