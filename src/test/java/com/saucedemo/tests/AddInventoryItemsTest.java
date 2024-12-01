package com.saucedemo.tests;

import com.codeborne.selenide.Selenide;
import com.saucedemo.jupiter.AddCartItem;
import com.saucedemo.jupiter.CookieLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.saucedemo.data.InventoryItems.*;

public class AddInventoryItemsTest extends TestBase {

    @CookieLogin
    @AddCartItem(inventoryitems = {backpack, tShirt, fleeceJacket, oneSie, bikeLight, jumperRed})
    @Test
    @DisplayName("Should authorize with valid credentials")
    void checkAddedItemsInCart() throws InterruptedException {
        inventoryPage.navigateToShoppingCart();

    }
}