package com.wellington.shoppingapi.dto;

import com.wellington.shoppingapi.entity.Item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemDTO {

    @NotBlank
    private String productIdentifier;
    @NotNull
    private Float price;

    public ItemDTO(String productIdentifier, Float price) {
        this.productIdentifier = productIdentifier;
        this.price = price;
    }

    public static ItemDTO converter(Item item) {
        return new ItemDTO(item.getProductIdentifier(), item.getPrice());
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public Float getPrice() {
        return price;
    }
}
