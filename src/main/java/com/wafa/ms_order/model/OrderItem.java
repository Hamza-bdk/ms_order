package com.wafa.ms_order.model;

import com.wafa.ms_order.model.constraint.Ean;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@Entity
@Table(name = "item")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private String imageUri;

    @Ean
    @NotBlank
    private String barcode;

    @Min(1)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Instant creationDate;

    @UpdateTimestamp
    private Instant lastModificationDate;

    @Version
    private int version;

    @PrePersist
    public void calculateImageUri() {
        imageUri = String.format(
            "http://localhost:8080/product-image/%s.png",
            name.replace(" ", "_")
        );
    }
}
