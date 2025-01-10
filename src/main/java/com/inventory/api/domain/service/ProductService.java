package com.inventory.api.domain.service;

import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product listProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> add(List<Product> product){
        if(product.size() >= 1){
            for(int i = 0; i < product.size(); i++){
               productRepository.save(product.get(i));
            }
        }

        return product;
    }

    public void removeProduct(Long id) {
       Optional<Product> product = productRepository.findById(id);
        productRepository.delete(product.get());
    }

    public Product updateProduct(Long id, Product product){
        Optional<Product> productCurrent = productRepository.findById(id);
        BeanUtils.copyProperties(product, productCurrent.get(), "id");
        return  productRepository.save(productCurrent.get());
    }

}
