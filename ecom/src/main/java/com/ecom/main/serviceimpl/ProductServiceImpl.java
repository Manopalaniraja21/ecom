package com.ecom.main.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.main.dto.ProductDTO;
import com.ecom.main.entity.Product;
import com.ecom.main.repository.ProductRepository;
import com.ecom.main.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
    private  ProductRepository productRepository;

   

    @Override
    public List<ProductDTO> getAllProductsForUser() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            productDTOs.add(convertToDTO(product));
        }
        return productDTOs;
    }

    @Override
    public List<Product> getAllProductsForAdmin() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductName(product.getProductName());
        dto.setProductPrice(product.getProductPrice());
        return dto;
    }
}
