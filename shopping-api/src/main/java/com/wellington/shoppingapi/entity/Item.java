package com.wellington.shoppingapi.entity;

import com.wellington.shoppingapi.dto.ItemDTO;

import javax.persistence.Embeddable;

@Embeddable
public class Item {

    private String productIdentifier;
    private Float price;

    public Item(String productIdentifier, Float price) {
        this.productIdentifier = productIdentifier;
        this.price = price;
    }

    public static Item converter(ItemDTO itemDTO) {
        return new Item(itemDTO.getProductIdentifier(), itemDTO.getPrice());
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public Float getPrice() {
        return price;
    }
}
