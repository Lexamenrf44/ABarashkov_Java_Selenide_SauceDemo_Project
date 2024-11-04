package com.saucedemo.jupiter;

import com.saucedemo.data.InventoryItems;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ExtendWith(AddCartItemExtension.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddCartItem {
    InventoryItems[] inventoryitems();
}
