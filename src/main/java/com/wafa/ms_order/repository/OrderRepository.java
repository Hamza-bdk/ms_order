package com.wafa.ms_order.repository;

import com.wafa.ms_order.model.Order;
import com.wafa.ms_order.model.ServiceType;
import com.wafa.ms_order.model.Status;
import com.wafa.ms_order.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStore(Store store);
    List<Order> findByServiceTypeAndStatusIn(ServiceType service, List<Status> statuses);
    List<Order> findByServiceTypeOrderByIdDesc(ServiceType service);

    @Query("""
        select o from Order o 
        join o.items it
        where o.status = 'DELIVERED' 
        and it.quantity > 1
    """)
    List<Order> findDeliveredOrdersWithItemQuantityGtOne();

}
