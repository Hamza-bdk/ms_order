package com.wafa.ms_order.model.constraint;

import com.wafa.ms_order.model.constraint.validator.EanValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EanValidator.class)
public @interface Ean {
}
