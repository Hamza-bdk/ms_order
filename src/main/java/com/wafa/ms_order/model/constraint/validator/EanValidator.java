package com.wafa.ms_order.model.constraint.validator;

import com.wafa.ms_order.model.constraint.Ean;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class EanValidator implements ConstraintValidator<Ean, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.isNotBlank(s) && s.length() <= 13;
    }
}
