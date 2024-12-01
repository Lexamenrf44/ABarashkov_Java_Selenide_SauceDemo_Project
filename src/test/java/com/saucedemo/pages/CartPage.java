package com.saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage<CartPage> {

    private final SelenideElement
            cartList = $("[data-test='cart-list']");

    @Override
    @Step("Check that Login Page is visible")
    public CartPage checkThatPageLoaded() {
        cartList.shouldBe(visible);
        return this;
    }


}
