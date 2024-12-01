package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class InventoryPage extends BasePage<InventoryPage> {

    private final SelenideElement
            inventoryContainer = $("[data-test='inventory-container']"),
            shoppingCartButton = $("[data-test='shopping-cart-link']"),
            burgerMenuButton = $("[id='react-burger-menu-btn']"),
            logoutSideBarButton = $("[data-test='logout-sidebar-link']");

    @Override
    public InventoryPage checkThatPageLoaded() {
        inventoryContainer.shouldBe(visible);
        return this;
    }

    @Step("Do manual logout via UI")
    public LoginPage doLogout() {
        checkThatPageLoaded();
        burgerMenuButton.shouldBe(visible).click();
        logoutSideBarButton.shouldBe(visible).click();

        return new LoginPage().checkThatPageLoaded();
    }

    @Step("Do logout on refresh after cookies being spoiled")
    public LoginPage logoutOnRefreshAfterCookiesSpoiled() {
        checkThatPageLoaded();
        sleep(3500);
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

    @Step("Navigage to shopping cart")
    public CartPage navigateToShoppingCart() {
        shoppingCartButton.shouldBe(visible).click();
        return new CartPage().checkThatPageLoaded();
    }
}
