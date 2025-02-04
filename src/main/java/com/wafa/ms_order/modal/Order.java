package com.wafa.ms_order.modal;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Store store;
    private List<OrderItem> items;
}
