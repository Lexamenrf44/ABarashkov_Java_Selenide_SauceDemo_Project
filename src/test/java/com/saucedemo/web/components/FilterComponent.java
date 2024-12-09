package com.saucedemo.web.components;

import com.codeborne.selenide.SelenideElement;
import com.saucedemo.data.FilterOptions;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class FilterComponent {

    private final SelenideElement self = $("[data-test='product-sort-container']");

    @Step("Filter inventory items by {option}")
    public FilterComponent filterByOption(FilterOptions optionFilter) {
        self.selectOption(optionFilter.getFilterOption());
        return this;
    }
}
