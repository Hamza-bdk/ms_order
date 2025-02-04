package com.wafa.ms_order.modal;

import lombok.*;

import java.time.Instant;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    private Long id;
    private String name;
    private Address address;
}
