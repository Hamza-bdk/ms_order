package com.wafa.ms_order.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Enabled;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @Embedded
    @AttributeOverride(name="zipCode", column = @Column(name = "zipcode"))
    private Address address;

    private Instant creationDate;

    @UpdateTimestamp
    private Instant lastModificationDate;

    @Version
    private int version;

}
