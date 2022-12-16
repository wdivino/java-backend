package com.wellington.shoppingapi.repository;

import com.wellington.shoppingapi.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findAllByUserIdentifier(String userIdentifier);
    List<Shop> findAllByTotalGreaterThan(Float total);
    List<Shop> findAllByDateGreaterThan(LocalDateTime date);
}
