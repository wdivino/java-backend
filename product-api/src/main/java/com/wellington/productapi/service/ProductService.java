package com.wellington.productapi.service;

import com.wellington.productapi.dto.ProductDTO;
import com.wellington.productapi.entity.Product;
import com.wellington.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductDTO::converter)
                .collect(Collectors.toList());
    }

    public ProductDTO getByProductIdentifier(String identifier) {
        Optional<Product> possivelProdutoEncontrado = productRepository.findByProductIdentifier(identifier);
        if (possivelProdutoEncontrado.isEmpty()) {
            return null;
        }
        return ProductDTO.converter(possivelProdutoEncontrado.get());
    }

    public ProductDTO salvar(ProductDTO productDTO) {
        Product produtoCadastrado = productRepository.save(Product.converter(productDTO));
        return ProductDTO.converter(produtoCadastrado);
    }

    public boolean excluir(long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
