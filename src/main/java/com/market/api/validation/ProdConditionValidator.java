package com.market.api.validation;

import com.market.api.entity.util.ProductCondition;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProdConditionValidator implements ConstraintValidator<ProdCondition, String> {

    private ProductCondition[] conditions;

    @Override
    public void initialize(ProdCondition constraintAnnotation) {
        this.conditions = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(StringUtils.isBlank(value) )
        {
            return false;
        }

        for ( ProductCondition productCondition : conditions)
        {
            if(StringUtils.equals(productCondition.getCondition(), value))
            {
                return true;
            }
        }

        return false;

    }
}
