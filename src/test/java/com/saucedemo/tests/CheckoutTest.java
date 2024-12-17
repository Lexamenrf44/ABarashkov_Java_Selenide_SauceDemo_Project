package com.saucedemo.tests;

import com.saucedemo.jupiter.AddCartItem;
import com.saucedemo.jupiter.CookieLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.saucedemo.data.InventoryItems.*;
import static com.saucedemo.data.InventoryItems.jumperRed;

public class CheckoutTest extends TestBase {

    @Test
    @CookieLogin(url = "checkout-step-two.html")
    @AddCartItem(inventoryitems = {backpack, tShirt, fleeceJacket, oneSie, bikeLight, jumperRed})
    @DisplayName("Some Name")
    public void testSomeName() {
        checkoutPage.checkThatPageLoaded();
    }
}
