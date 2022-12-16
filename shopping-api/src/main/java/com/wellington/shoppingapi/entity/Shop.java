package com.wellington.shoppingapi.entity;

import com.wellington.shoppingapi.dto.ItemDTO;
import com.wellington.shoppingapi.dto.ShopDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userIdentifier;
    private Float total;
    private Date date;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))
    private List<Item> items;

    public Shop(String userIdentifier, Date date) {
        this.userIdentifier = userIdentifier;
        this.date = date;
    }

    public Shop(String userIdentifier, Float total, Date date) {
        this.userIdentifier = userIdentifier;
        this.total = total;
        this.date = date;
    }

    public static Shop converter(ShopDTO shopDTO) {
        Float total = calculateTotal(shopDTO.getItems());
        Shop shop = new Shop(shopDTO.getUserIdentifier(), total, shopDTO.getDate());
        shopDTO.getItems()
                .stream()
                .map(Item::converter)
                .forEach(item -> shop.addItem(item));
        return shop;
    }

    private static Float calculateTotal(List<ItemDTO> items) {
        return items
                .stream()
                .map(ItemDTO::getPrice)
                .reduce((float) 0, Float::sum);
    }

    public void addItem(Item item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

    public long getId() {
        return id;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public Float getTotal() {
        return total;
    }

    public Date getDate() {
        return date;
    }

    public List<Item> getItems() {
        return items;
    }
}
