package com.saucedemo.tests;

import com.saucedemo.jupiter.CookieLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.saucedemo.data.FilterOptions.*;

public class FilterTest extends TestBase {

    @CookieLogin
    @Test
    @DisplayName("Should filter price high to low")
    public void filterByPriceHighToLowTest() {
        inventoryPage
                .filterByOption(priceHighToLow)
                .assertByOption(priceHighToLow);
    }

    @CookieLogin
    @Test
    @DisplayName("Should filter price low to high")
    public void filterByPriceLowToHighTest() {
        inventoryPage
                .filterByOption(priceLowToHigh)
                .assertByOption(priceLowToHigh);
    }

    @CookieLogin
    @Test
    @DisplayName("Should filter by name A to Z")
    public void filterByNameAToZTest() {
        inventoryPage
                .filterByOption(nameAtoZ)
                .assertByOption(nameAtoZ);
    }

    @CookieLogin
    @Test
    @DisplayName("Should filter by name by Z to A")
    public void filterByNameZToATest() {
        inventoryPage
                .filterByOption(nameZtoA)
                .assertByOption(nameZtoA);
    }
}
