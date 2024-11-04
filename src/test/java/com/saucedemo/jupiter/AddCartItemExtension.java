package com.saucedemo.jupiter;

import com.codeborne.selenide.Selenide;
import com.saucedemo.data.InventoryItems;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;

import java.util.Arrays;
import java.util.Optional;

public class AddCartItemExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        Optional<AddCartItem> annotation = AnnotationSupport.findAnnotation(context.getRequiredTestMethod(), AddCartItem.class);

        if (annotation.isPresent()) {
            InventoryItems[] items = annotation.get().inventoryitems();

            String[] itemStr = new String[items.length];

            for (int i = 0; i < items.length; i++) {
                itemStr[i] = items[i].getNumber();
            }

            Selenide.localStorage().setItem("cart-contents", Arrays.toString(itemStr));
        }
    }
}
