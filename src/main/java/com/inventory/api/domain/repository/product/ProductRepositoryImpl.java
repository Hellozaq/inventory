package com.inventory.api.domain.repository.product;

import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.repository.filter.ProductFilter;
import org.hibernate.Criteria;
import org.springframework.util.ObjectUtils;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Product> filter(ProductFilter productFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        Root<Product> root = criteria.from(Product.class);


        Predicate[] predicates = createRestrictions(productFilter, builder, root);
        criteria.where(predicates);
        TypedQuery<Product> query = manager.createQuery(criteria);
        return query.getResultList();

    }

    private Predicate[] createRestrictions(ProductFilter productFilter, CriteriaBuilder builder, Root<Product> root) {

        List<Predicate> predicates = new ArrayList<>();

        if(!ObjectUtils.isEmpty(productFilter.getEstablishment())){
            predicates.add(builder.like(
                    builder.lower(root.get("establishment")), "%" + productFilter.getEstablishment().toLowerCase() + "%"
            ));
        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
