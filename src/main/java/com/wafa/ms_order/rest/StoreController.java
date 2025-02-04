package com.wafa.ms_order.rest;

import com.wafa.ms_order.model.Order;
import com.wafa.ms_order.model.Store;
import com.wafa.ms_order.service.StoreService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {
    private final StoreService storeService;

    @GetMapping("/last-modified")
    public Store findLastModifiedByName(@RequestParam("name") String name) {
        return storeService.findLastModifiedByName(name);
    }
}
