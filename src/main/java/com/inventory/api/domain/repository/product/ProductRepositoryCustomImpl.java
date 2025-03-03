package com.inventory.api.domain.repository.product;

import com.inventory.api.domain.model.Model;
import com.inventory.api.domain.model.Product;
import com.inventory.api.domain.model.Professional;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> searchProducts(String serialNumber, String name, String professionalName, String modelName) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);

        // Fazendo JOIN com Professional e Model
        Join<Product, Professional> professionalJoin = root.join("professional", JoinType.LEFT);
        Join<Product, Model> modelJoin = root.join("model", JoinType.LEFT);

        // Lista de filtros (Predicates)
        List<Predicate> predicates = new ArrayList<>();

        if (serialNumber != null && !serialNumber.isEmpty()) {
            predicates.add(cb.like(root.get("serialNumber"), "%" + serialNumber + "%"));
        }
        if (name != null && !name.isEmpty()) {
            predicates.add(cb.like(root.get("name"), "%" + name + "%"));
        }
        if (professionalName != null && !professionalName.isEmpty()) {
            predicates.add(cb.like(professionalJoin.get("name"), "%" + professionalName + "%"));
        }
        if (modelName != null && !modelName.isEmpty()) {
            predicates.add(cb.like(modelJoin.get("name"), "%" + modelName + "%"));
        }

        // Aplicando os filtros na query
        query.select(root).where(cb.and(predicates.toArray(new Predicate[0])));

        // Executando a query
        TypedQuery<Product> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
