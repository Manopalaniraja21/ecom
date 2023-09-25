package com.ecom.main.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.main.dto.ProductDTO;
import com.ecom.main.entity.Product;
import com.ecom.main.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
    private  ProductService productService;

    @GetMapping("/user")
    public List<ProductDTO> getAllProductsForUser() {
        return productService.getAllProductsForUser();
    }

    @GetMapping("/admin")
    public List<Product> getAllProductsForAdmin() {
        return productService.getAllProductsForAdmin();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/")
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
