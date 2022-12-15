package com.wellington.productapi.dto;

import com.wellington.productapi.entity.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ProductDTO {

    private long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotBlank
    private String productIdentifier;
    @NotNull
    private Float preco;
    @NotNull
    private CategoryDTO categoryDTO;

    public ProductDTO(long id, String nome, String descricao, String productIdentifier, Float preco, CategoryDTO categoryDTO) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.productIdentifier = productIdentifier;
        this.preco = preco;
        this.categoryDTO = categoryDTO;
    }

    public static ProductDTO converter(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getNome(),
                product.getDescricao(),
                product.getProductIdentifier(),
                product.getPreco(),
                Objects.isNull(product.getCategory()) ? null : CategoryDTO.converter(product.getCategory())
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

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }
}
