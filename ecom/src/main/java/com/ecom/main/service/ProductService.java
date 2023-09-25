package com.ecom.main.service;

import java.util.List;

import com.ecom.main.dto.ProductDTO;
import com.ecom.main.entity.Product;

public interface ProductService {
	 List<ProductDTO> getAllProductsForUser();
	    
	 List<Product> getAllProductsForAdmin();
	    
	 Product getProductById(Long id);
	    
	 void saveProduct(Product product);
	    
	 void deleteProduct(Long id);
}
