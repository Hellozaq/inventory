package com.inventory.api.domain.repository.product;

import com.inventory.api.domain.model.Product;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> searchProducts(String serialNumber, String name, String professionalName, String modelName);
}
