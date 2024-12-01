package com.saucedemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CartModel {
    private String title;
    private String description;
    private BigDecimal price;
}
