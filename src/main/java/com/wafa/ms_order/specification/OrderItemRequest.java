package com.wafa.ms_order.specification;

import com.wafa.ms_order.model.OrderItem;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderItemRequest implements Specification<OrderItem> {

    private String name;
    private Integer minQuantity;
    private Integer maxQuantity;
    private Instant createdBefore;


    @Override
    public Predicate toPredicate(Root<OrderItem> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotBlank(name)) {
            predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("name")),
                    "%" + name.toLowerCase() + "%"
            ));
        }

        if (minQuantity != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("quantity"), minQuantity));
        }

        if (maxQuantity != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("quantity"), maxQuantity));
        }

        if (createdBefore != null) {
            predicates.add(criteriaBuilder.lessThan(root.get("createdDate"), createdBefore));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
