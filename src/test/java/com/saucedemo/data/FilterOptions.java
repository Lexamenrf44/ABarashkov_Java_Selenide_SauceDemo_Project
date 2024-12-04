package com.saucedemo.data;

import com.saucedemo.model.CartModel;
import com.saucedemo.utils.PriceComparator;
import com.saucedemo.utils.TitleComparator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;

@RequiredArgsConstructor
@Getter
public enum FilterOptions {
    nameAtoZ("Name (A to Z)", new TitleComparator()),
    nameZtoA("Name (Z to A)", new TitleComparator().reversed()),
    priceLowToHigh("Price (low to high)", new PriceComparator()),
    priceHighToLow("Price (high to low)", new PriceComparator().reversed());

    private final String filterOption;
    private final Comparator<CartModel> comparator;
}
