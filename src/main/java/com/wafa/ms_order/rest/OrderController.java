package com.wafa.ms_order.rest;

import com.wafa.ms_order.modal.Order;
import com.wafa.ms_order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> getOrders(){
        return orderService.findAll();
    }

    @GetMapping("{id}")
    public Order findById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

}
