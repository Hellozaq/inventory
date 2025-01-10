package com.inventory.api.domain.repository.product;

import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.repository.filter.ProductFilter;

import java.util.List;

public interface ProductRepositoryQuery {
    public List<Product> filter(ProductFilter productFilter);
}
