package com.wafa.ms_order.service;

import com.wafa.ms_order.model.OrderItem;
import com.wafa.ms_order.specification.OrderItemRequest;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> findAll(OrderItemRequest request);
}
