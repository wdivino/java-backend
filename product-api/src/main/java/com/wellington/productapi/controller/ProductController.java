package com.wellington.productapi.controller;

import com.wellington.productapi.dto.ProductDTO;
import com.wellington.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

    @GetMapping("{identifier}")
    public ProductDTO getByIdentifier(@PathVariable String identifier) {
        return productService.getByProductIdentifier(identifier);
    }

    @PostMapping
    public ProductDTO newProduct(@RequestBody @Valid ProductDTO newProduct) {
        return productService.salvar(newProduct);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id) {
        return productService.excluir(id);
    }
}
