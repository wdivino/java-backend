package com.wellington.shoppingapi.dto;

import com.wellington.shoppingapi.entity.Shop;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ShopDTO {

    private Long id;
    @NotBlank
    private String userIdentifier;
    @NotNull
    private Float total;
    @NotNull
    private LocalDateTime date;
    @NotNull
    private List<ItemDTO> items;

    public ShopDTO(Long id, String userIdentifier, Float total, LocalDateTime date, List<ItemDTO> items) {
        this.id = id;
        this.userIdentifier = userIdentifier;
        this.total = total;
        this.date = date;
        this.items = items;
    }

    public static ShopDTO converter(Shop shop) {
        return new ShopDTO(
                shop.getId(),
                shop.getUserIdentifier(),
                shop.getTotal(),
                shop.getDate(),
                shop.getItems().stream()
                        .map(ItemDTO::converter)
                        .collect(Collectors.toList())
        );
    }

    public Long getId() {
        return id;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public Float getTotal() {
        return total;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public List<ItemDTO> getItems() {
        return items;
    }
}
