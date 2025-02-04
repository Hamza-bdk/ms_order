package com.wafa.ms_order.rest;

import com.wafa.ms_order.model.Order;
import com.wafa.ms_order.model.ServiceType;
import com.wafa.ms_order.model.Status;
import com.wafa.ms_order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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
    @ApiResponse(responseCode = "404", description = "No order with given id")
    @ApiResponse(responseCode = "200", description = "Order found")
    public Order findById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @GetMapping("/store/{storeId}")
    @Operation(description = "Search orders for specific store with id")
    public List<Order> findByStoreId(@PathVariable("storeId") Long storeId) {
        log.info("Searching order for store with id {}", storeId);
        return orderService.findByStoreId(storeId);
    }

    @GetMapping("/service-and-status")
    @Operation(description = "Search orders by service and list statuses")
    public List<Order> findByServiceAndListStatuses(
            @RequestParam("service") ServiceType service,
            @RequestParam("status") List<Status> statuses) {
        return orderService.findByServiceTypeAndStatusIn(service, statuses);
    }


}
