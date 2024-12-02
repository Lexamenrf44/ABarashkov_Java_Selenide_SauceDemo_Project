package com.saucedemo.data;

public enum InventoryItems {
    backpack("4", "29.99"),
    bikeLight("0", "9.99"),
    tShirt("1", "15.99"),
    fleeceJacket("5", "49.99"),
    oneSie("2", "7.99"),
    jumperRed("3", "15.99");

    InventoryItems(String number, String price) {
        this.number = number;
        this.price = price;
    }

    private final String number;
    private final String price;

    public String getNumber() {
        return number;
    }

    public String getPrice() {
        return price;
    }
}
