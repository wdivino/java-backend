package com.wellington.shoppingapi.service;

import com.wellington.shoppingapi.dto.ShopDTO;
import com.wellington.shoppingapi.entity.Shop;
import com.wellington.shoppingapi.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<ShopDTO> getAll() {
        return shopRepository.findAll()
                .stream()
                .map(ShopDTO::converter)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier) {
        return shopRepository.findAllByUserIdentifier(userIdentifier)
                .stream()
                .map(ShopDTO::converter)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(Date date) {
        return shopRepository.findAllByDateGreaterThanEquals(date)
                .stream()
                .map(ShopDTO::converter)
                .collect(Collectors.toList());
    }

    public ShopDTO findById(long id) {
        Optional<Shop> possibleCartFound = shopRepository.findById(id);
        if (possibleCartFound.isEmpty()) return null;
        return ShopDTO.converter(possibleCartFound.get());
    }

    public ShopDTO save(ShopDTO newShop) {
        Shop shopSaved = shopRepository.save(Shop.converter(newShop));
        return ShopDTO.converter(shopSaved);
    }
}
