package com.wellington.productapi.entity;

import com.wellington.productapi.dto.ProductDTO;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private String productIdentifier;
    private Float preco;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String nome, String descricao, String productIdentifier, Float preco, Category category) {
        this.nome = nome;
        this.descricao = descricao;
        this.productIdentifier = productIdentifier;
        this.preco = preco;
        this.category = category;
    }

    public static Product converter(ProductDTO productDTO) {
        return new Product(
                productDTO.getNome(),
                productDTO.getDescricao(),
                productDTO.getProductIdentifier(),
                productDTO.getPreco(),
                Objects.isNull(productDTO.getCategoryDTO()) ? null : Category.converter(productDTO.getCategoryDTO())
        );
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public Float getPreco() {
        return preco;
    }

    public Category getCategory() {
        return category;
    }
}
