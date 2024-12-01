package com.saucedemo.utils;

import com.saucedemo.model.CartModel;

import java.util.Comparator;

public class TitleComparator implements Comparator<CartModel> {


    @Override
    public int compare(CartModel o1, CartModel o2) {
        return 0;
    }

    @Override
    public Comparator<CartModel> reversed() {
        return Comparator.super.reversed();
    }
}
