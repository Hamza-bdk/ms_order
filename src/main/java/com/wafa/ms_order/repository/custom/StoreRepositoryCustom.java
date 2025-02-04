package com.wafa.ms_order.repository.custom;

import com.wafa.ms_order.model.Store;

import java.util.Optional;

public interface StoreRepositoryCustom {
    Optional<Store> findLastModifiedByName(String name);
}
