package com.saucedemo.tests;

import com.saucedemo.jupiter.AddCartItem;
import com.saucedemo.jupiter.CookieLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.saucedemo.data.InventoryItems.*;

public class AddInventoryItemsTest extends TestBase {

    @CookieLogin
    @AddCartItem(inventoryitems = {backpack, tShirt})
    @Test
    @DisplayName("Should authorize with valid credentials")
    void checkAddedItemsInCart() throws InterruptedException {

    }
}