package com.wafa.ms_order.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private Long id;
    private String name;
    private String imageUri;
    private String barcode;
    private int quantity;
}
