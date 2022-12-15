package com.wellington.productapi.dto;

import com.wellington.productapi.entity.Category;

public class CategoryDTO {

    private long id;
    private String nome;

    public CategoryDTO(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static CategoryDTO converter(Category category) {
        return new CategoryDTO(category.getId(), category.getNome());
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
