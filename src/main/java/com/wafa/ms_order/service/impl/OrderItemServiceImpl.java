package com.wafa.ms_order.service.impl;

import com.wafa.ms_order.model.OrderItem;
import com.wafa.ms_order.repository.OrderItemRepository;
import com.wafa.ms_order.service.OrderItemService;
import com.wafa.ms_order.specification.OrderItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> findAll(OrderItemRequest request) {
        return orderItemRepository.findAll(request);
    }
}
