package com.saucedemo.tests;

import com.codeborne.selenide.ElementsCollection;
import com.saucedemo.jupiter.CookieLogin;
import com.saucedemo.model.CartModel;
import com.saucedemo.utils.PriceComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.saucedemo.utils.MathUtils.convertToBigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

public class FilterTest extends TestBase {

    @CookieLogin
    @Test
    @DisplayName("Should filter price high to low")
    public void filterPriceHighToLowTest() {
        $("[data-test='product-sort-container']").selectOption("Price (high to low)");

        ElementsCollection itemsCollection = $$("[data-test='inventory-item']");
        List<CartModel> filteredInventoryItems = new ArrayList<>();

        itemsCollection.forEach(e -> {
            filteredInventoryItems.add(
                   CartModel.builder()
                           .title(e.$("[data-test='inventory-item-name']").getText())
                           .description(e.$("[data-test='inventory-item-desc']").getText())
                           .price(convertToBigDecimal(e.$("[data-test='inventory-item-price']").getText()))
                           .build()
            );
        });

        List<CartModel> sortedItems = new ArrayList<>(filteredInventoryItems);

        sortedItems.sort(new PriceComparator().reversed());

        assertThat(filteredInventoryItems).isEqualTo(sortedItems);
    }

    @CookieLogin
    @Test
    @DisplayName("Should filter price low to high")
    public void filterPriceLowToHighTest() {
        $("[data-test='product-sort-container']").selectOption("Price (low to high)");

        ElementsCollection itemsCollection = $$("[data-test='inventory-item']");
        List<CartModel> filteredInventoryItems = new ArrayList<>();

        itemsCollection.forEach(e -> {
            filteredInventoryItems.add(
                    CartModel.builder()
                            .title(e.$("[data-test='inventory-item-name']").getText())
                            .description(e.$("[data-test='inventory-item-desc']").getText())
                            .price(convertToBigDecimal(e.$("[data-test='inventory-item-price']").getText()))
                            .build()
            );
        });

        List<CartModel> sortedItems = new ArrayList<>(filteredInventoryItems);

        sortedItems.sort(new PriceComparator());

        assertThat(filteredInventoryItems).isEqualTo(sortedItems);
    }
}
