package com.wafa.ms_order.service;

import com.wafa.ms_order.common.exception.NotFoundException;
import com.wafa.ms_order.modal.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order findById(Long id) throws NotFoundException;
    Order save(Order order);
}
