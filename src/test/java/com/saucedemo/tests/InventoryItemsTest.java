package com.saucedemo.tests;

import com.saucedemo.jupiter.CookieLogin;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class InventoryItemsTest extends TestBase {

    @CookieLogin(url = "inventory-item.html?id=0")
    @Test
    public void checkBikeLightItem() throws IOException {
        itemsPage.assertBikeLightItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=1")
    @Test
    public void checkBoltTShirtItem() throws IOException {
        itemsPage.assertBoltTShirtItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=2")
    @Test
    public void checkOnesieItem() throws IOException {
        itemsPage.assertOnesieItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=3")
    @Test
    public void checkRedJumperItem() throws IOException {
        itemsPage.assertRedJumperItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=4")
    @Test
    public void checkBackpackItem() throws IOException {
        itemsPage.assertBackpackItemImage();
    }

    @CookieLogin(url = "inventory-item.html?id=5")
    @Test
    public void checkFleeceJacketItem() throws IOException {
        itemsPage.assertFleeceJacketItemImage();
    }
}
