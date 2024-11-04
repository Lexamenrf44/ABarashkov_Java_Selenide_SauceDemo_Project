package com.saucedemo.tests;

import com.saucedemo.data.InventoryItems;
import com.saucedemo.data.Password;
import com.saucedemo.data.Username;
import com.saucedemo.jupiter.AddCartItem;
import com.saucedemo.jupiter.CookieLogin;
import com.saucedemo.support.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.saucedemo.data.InventoryItems.*;
import static java.lang.Thread.sleep;

public class AddInventoryItemsTest extends TestBase {

    @CookieLogin
    @AddCartItem(inventoryitems = {backpack, tShirt})
    @Test
    @DisplayName("Should authorize with valid credentials")
    void loginWithInvalidCredentials() throws InterruptedException {

        sleep(10000);
    }
}