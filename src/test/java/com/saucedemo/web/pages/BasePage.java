package com.saucedemo.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.saucedemo.model.CartModel;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public abstract class BasePage <T extends BasePage<?>> {

    private final ElementsCollection inventoryItems = $$("[data-test='inventory-item']");

    @SuppressWarnings("unchecked")
    @Nonnull
    @Step("Clear Browser Cookies")
    public T manuallyClearCookies() {
        clearBrowserCookies();
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Nonnull
    @Step("Clear Browser Cookies")
    public List<CartModel> getItemList() {
        List<CartModel> items = new ArrayList<>();

        inventoryItems.forEach(e -> {
            items.add(
                    new CartModel(e)
            );
        });

        return items;
    }

    public abstract T checkThatPageLoaded();
}
