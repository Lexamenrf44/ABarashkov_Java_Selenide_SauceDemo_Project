package com.saucedemo.utils;

import com.saucedemo.model.CartModel;

import java.util.Comparator;

public class PriceComparator implements Comparator<CartModel> {

    @Override
    public int compare(CartModel o1, CartModel o2) {
        if (o1.getPrice().compareTo(o2.getPrice()) > 0) {
            return 1;
        } else if (o1.getPrice().compareTo(o2.getPrice()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public Comparator<CartModel> reversed() {
        return Comparator.super.reversed();
    }
}
