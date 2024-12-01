package com.saucedemo.tests;

import com.saucedemo.jupiter.CookieLogin;
import org.junit.jupiter.api.Test;

public class InventoryItemsTest extends TestBase {

    @CookieLogin(url = "inventory-item.html?id=0")
    @Test
    public void checkBikeLightItem() {
        itemsPage.assertBikeLightItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=1")
    @Test
    public void checkBoltTShirtItem() {
        itemsPage.assertBoltTShirtItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=2")
    @Test
    public void checkOnesieItem() {
        itemsPage.assertOnesieItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=3")
    @Test
    public void checkRedJumperItem() {
        itemsPage.assertRedJumperItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=4")
    @Test
    public void checkBackpackItem() {
        itemsPage.assertBackpackItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=5")
    @Test
    public void checkFleeceJacketItem() {
        itemsPage.assertFleeceJacketItemImage();
    }
}
