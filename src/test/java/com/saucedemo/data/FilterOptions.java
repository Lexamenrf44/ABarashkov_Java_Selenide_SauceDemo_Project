package com.saucedemo.data;

public enum FilterOptions {
    nameAtoZ("Name (A to Z)"),
    nameZtoA("Name (Z to A)"),
    priceLowToHigh("Price (low to high)"),
    priceHighToLow("Price (high to low)");

    private final String filterOption;

    FilterOptions(String filterOption) {
        this.filterOption = filterOption;
    }

    public String getFilterOption() {
        return filterOption;
    }
}
