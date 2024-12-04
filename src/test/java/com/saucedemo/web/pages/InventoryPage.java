package com.saucedemo.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.saucedemo.data.FilterOptions;
import com.saucedemo.model.CartModel;
import com.saucedemo.utils.PriceComparator;
import com.saucedemo.web.components.FilterComponent;
import com.saucedemo.web.components.NavbarComponent;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.saucedemo.utils.MathUtils.convertToBigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

public class InventoryPage extends BasePage<InventoryPage> {

    private final NavbarComponent navbarComponent = new NavbarComponent();
    private final FilterComponent filterComponent = new FilterComponent();

    private final SelenideElement
            inventoryContainer = $("[data-test='inventory-container']"),
            shoppingCartButton = $("[data-test='shopping-cart-link']"),
            itemName = $("[data-test='inventory-item-name']"),
            itemDescription = $("[data-test='inventory-item-desc']"),
            itemPrice = $("[data-test='inventory-item-price']");

    private final ElementsCollection inventoryItems = $$("[data-test='inventory-item']");

    @Override
    public InventoryPage checkThatPageLoaded() {
        inventoryContainer.shouldBe(visible);
        return this;
    }

    @Step("Do manual logout via UI")
    public LoginPage doLogout() {
        checkThatPageLoaded();
        navbarComponent.clickLogoutButton();

        return new LoginPage().checkThatPageLoaded();
    }

    @Step("Do logout on refresh after cookies being spoiled")
    public LoginPage logoutOnRefreshAfterCookiesSpoiled(int wait) {
        checkThatPageLoaded();
        sleep(wait);
        refresh();

        return new LoginPage().checkThatPageLoaded();
    }

    @Step("Do logout on refresh after manually clearing cookies")
    public LoginPage logoutOnRefreshAfterManuallyClearingCookies() {
        checkThatPageLoaded();
        manuallyClearCookies();
        refresh();

        return new LoginPage().checkThatPageLoaded();
    }

    @Step("Filter by Price (High to Low)")
    public InventoryPage filterByPriceHighToLow() {
        filterComponent.filterByOption(FilterOptions.priceHighToLow);

        List<CartModel> filteredInventoryItems = new ArrayList<>();

        inventoryItems.forEach(e -> {
            filteredInventoryItems.add(
                    CartModel.builder()
                            .title(itemName.getText())
                            .description(itemDescription.getText())
                            .price(convertToBigDecimal(itemPrice.getText()))
                            .build()
            );
        });

        List<CartModel> sortedItems = new ArrayList<>(filteredInventoryItems);

        sortedItems.sort(new PriceComparator().reversed());

        assertThat(filteredInventoryItems).isEqualTo(sortedItems);

        return this;
    }

    @Step("Filter by Price (Low to High)")
    public InventoryPage filterByPriceLowToHigh() {
        filterComponent.filterByOption(FilterOptions.priceLowToHigh);

        List<CartModel> filteredInventoryItems = new ArrayList<>();

        inventoryItems.forEach(e -> {
            filteredInventoryItems.add(
                    CartModel.builder()
                            .title(itemName.getText())
                            .description(itemDescription.getText())
                            .price(convertToBigDecimal(itemPrice.getText()))
                            .build()
            );
        });

        List<CartModel> sortedItems = new ArrayList<>(filteredInventoryItems);

        sortedItems.sort(new PriceComparator());

        assertThat(filteredInventoryItems).isEqualTo(sortedItems);

        return this;
    }

    @Step("Navigage to shopping cart")
    public CartPage navigateToShoppingCart() {
        shoppingCartButton.click();
        return new CartPage().checkThatPageLoaded();
    }
}
