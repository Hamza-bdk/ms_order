package com.wafa.ms_order.repository.custom.impl;

import com.wafa.ms_order.model.Store;
import com.wafa.ms_order.repository.custom.StoreRepositoryCustom;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class StoreRepositoryCustomImpl implements StoreRepositoryCustom {

    private final EntityManager em;

    @Override
    public Optional<Store> findLastModifiedByName(String name) {
        var query = em.createQuery("SELECT s FROM Store s WHERE s.name = :name ORDER BY s.lastModificationDate DESC", Store.class);
        query.setParameter("name", name);
        query.setMaxResults(1);
        return Optional.ofNullable(query.getSingleResult());
    }
}
