package com.saucedemo.tests;

import com.saucedemo.jupiter.CookieLogin;
import org.junit.jupiter.api.Test;

public class InventoryItemsTest extends TestBase {

    @CookieLogin(url = "inventory-item.html?id=0")
    @Test
    public void checkBikeLightItem() {
        itemsPage
                .checkThatPageLoaded()
                .assertBikeLightItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=1")
    @Test
    public void checkBoltTShirtItem() {
        itemsPage
                .checkThatPageLoaded()
                .assertBoltTShirtItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=2")
    @Test
    public void checkOnesieItem() {
        itemsPage
                .checkThatPageLoaded()
                .assertOnesieItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=3")
    @Test
    public void checkRedJumperItem() {
        itemsPage
                .checkThatPageLoaded()
                .assertRedJumperItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=4")
    @Test
    public void checkBackpackItem() {
        itemsPage
                .checkThatPageLoaded()
                .assertBackpackItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=5")
    @Test
    public void checkFleeceJacketItem() {
        itemsPage
                .checkThatPageLoaded()
                .assertFleeceJacketItemImage();
    }
}
