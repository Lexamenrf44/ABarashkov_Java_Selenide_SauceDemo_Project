package com.saucedemo.model;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

import static com.saucedemo.utils.MathUtils.convertToBigDecimal;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CartModel {
    private String title;
    private String description;
    private BigDecimal price;

    public CartModel(SelenideElement element) {

        this.title = element.$("[data-test='inventory-item-name']").getText();
        this.description = element.$("[data-test='inventory-item-desc']").getText();
        this.price = convertToBigDecimal(element.$("[data-test='inventory-item-price']").getText());
    }
}
