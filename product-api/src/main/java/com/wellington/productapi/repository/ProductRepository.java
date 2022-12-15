package com.wellington.productapi.repository;

import com.wellington.productapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p "
            + "FROM product p "
            + "JOIN category c ON p.category.id = c.id "
            + "WHERE c.id =: categoryId")
    List<Product> getByCategory(@Param("categoryId") long categoryId);
    Optional<Product> findByProductIdentifier(String productIdentifier);
}
