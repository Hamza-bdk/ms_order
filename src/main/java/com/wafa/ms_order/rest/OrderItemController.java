package com.wafa.ms_order.rest;

import com.wafa.ms_order.model.Order;
import com.wafa.ms_order.model.OrderItem;
import com.wafa.ms_order.service.OrderItemService;
import com.wafa.ms_order.specification.OrderItemRequest;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @GetMapping("/search")
    public List<OrderItem> findById(OrderItemRequest request) {
        return orderItemService.findAll(request);
    }

}
