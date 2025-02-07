package com.wafa.ms_order.service.impl;

import com.wafa.ms_order.common.exception.NotFoundException;
import com.wafa.ms_order.model.Order;
import com.wafa.ms_order.model.ServiceType;
import com.wafa.ms_order.model.Status;
import com.wafa.ms_order.repository.OrderRepository;
import com.wafa.ms_order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) throws NotFoundException {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("No order with id " + id));
    }

    @Override
    @Transactional
    public Order save(Order order) {
        var savedOrder = orderRepository.save(order);
        return savedOrder;
    }

    @Override
    public List<Order> findByStoreId(Long id) {
        return orderRepository.findByStoreId(id);
    }

    @Override
    public List<Order> findByServiceTypeAndStatusIn(ServiceType service, List<Status> statuses) {
        return orderRepository.findByServiceTypeAndStatusIn(service, statuses);
    }


}
