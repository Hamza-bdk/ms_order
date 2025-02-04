package com.wafa.ms_order.service.impl;

import com.wafa.ms_order.common.exception.NotFoundException;
import com.wafa.ms_order.modal.Order;
import com.wafa.ms_order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Map<Long, Order> ORDER_REPOSITORY = new HashMap<>();


    @Override
    public List<Order> findAll() {
        return new ArrayList<>(ORDER_REPOSITORY.values());
    }

    @Override
    public Order findById(Long id) throws NotFoundException {
        return Optional.ofNullable(ORDER_REPOSITORY.get(id)).orElseThrow(() -> new NotFoundException("No order with id " + id));
    }

    @Override
    public Order save(Order order) {
        return ORDER_REPOSITORY.put(order.getId(), order);
    }
}
