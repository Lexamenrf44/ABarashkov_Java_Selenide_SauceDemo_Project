package com.saucedemo.tests;

import com.codeborne.selenide.SelenideElement;
import com.saucedemo.jupiter.AddCartItem;
import com.saucedemo.jupiter.CookieLogin;
import com.saucedemo.model.CartModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.saucedemo.data.InventoryItems.*;
import static com.saucedemo.utils.MathUtils.*;

public class CheckoutTest extends TestBase {

    private final SelenideElement
            subtotalPrice = $("[data-test='subtotal-label']"),
            taxSum = $("[data-test='tax-label']"),
            totalPrice = $("[data-test='total-label']");

    private final BigDecimal percent = convertToBigDecimal(1.08);

    @Test
    @AddCartItem(inventoryitems = {backpack, tShirt, fleeceJacket, oneSie, bikeLight, jumperRed})
    @CookieLogin(url = "checkout-step-two.html")
    @DisplayName("Some Name")
    public void testSomeName() {
        checkoutPage.checkThatPageLoaded();

        BigDecimal subtotal = convertToBigDecimal(subtotalPrice.getText());
        BigDecimal tax = convertToBigDecimal(taxSum.getText());
        BigDecimal total = convertToBigDecimal(totalPrice.getText());

        BigDecimal totalCalc = multiplyBigDecimalWithRoundingMode(percent, subtotal, RoundingMode.UP);

        assertEqualsBigDecimal(total, totalCalc);

        BigDecimal taxCalc = subtractBigDecimalWithRoundingMode(total, subtotal, RoundingMode.UP);

        assertEqualsBigDecimal(tax, taxCalc);

        List<CartModel> itemList = checkoutPage.getItemList();

        BigDecimal subtotalCalc = BigDecimal.valueOf(0);

        for (CartModel item : itemList) {
            subtotalCalc = subtotalCalc.add(item.getPrice());
        }

        assertEqualsBigDecimal(subtotalCalc, subtotal);
    }
}
