package com.saucedemo.tests;

import com.saucedemo.jupiter.CookieLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FilterTest extends TestBase {

    @CookieLogin
    @Test
    @DisplayName("Should filter price high to low")
    public void filterPriceHighToLowTest() {
        inventoryPage.filterByPriceHighToLow();
    }

    @CookieLogin
    @Test
    @DisplayName("Should filter price low to high")
    public void filterPriceLowToHighTest() {
        inventoryPage.filterByPriceLowToHigh();
    }
}
