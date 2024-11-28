package com.saucedemo.pages;

import io.qameta.allure.Step;

import javax.annotation.Nonnull;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public abstract class BasePage <T extends BasePage<?>> {

    @SuppressWarnings("unchecked")
    @Nonnull
    @Step("Clear Browser Cookies")
    public T manuallyClearCookies() {
        clearBrowserCookies();
        return (T) this;
    }

    public abstract InventoryPage checkThatPageLoaded();
}
