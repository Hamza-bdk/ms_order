package com.wafa.ms_order.repository;

import com.wafa.ms_order.model.Store;
import com.wafa.ms_order.repository.custom.StoreRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
