package com.saucedemo.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends BasePage<CheckoutPage> {

    private final SelenideElement
            checkputContainer = $("[data-test='cart-list']");

    @Override
    public CheckoutPage checkThatPageLoaded() {
        checkputContainer.shouldBe(visible);
        return this;
    }
}
