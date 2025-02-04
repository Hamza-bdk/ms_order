package com.wafa.ms_order.service;

import com.wafa.ms_order.common.exception.NotFoundException;
import com.wafa.ms_order.model.Order;
import com.wafa.ms_order.model.ServiceType;
import com.wafa.ms_order.model.Status;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order findById(Long id) throws NotFoundException;
    Order save(Order order);
    List<Order> findByStoreId(Long id);
    List<Order> findByServiceTypeAndStatusIn(ServiceType service, List<Status> statuses);
}
