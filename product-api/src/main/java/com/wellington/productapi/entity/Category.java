package com.wellington.productapi.entity;

import com.wellington.productapi.dto.CategoryDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    public Category(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static Category converter(CategoryDTO categoryDTO) {
        return new Category(categoryDTO.getId(), categoryDTO.getNome());
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
