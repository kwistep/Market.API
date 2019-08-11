package com.market.api.validation;

import com.market.api.entity.util.Status;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusCheckValidator implements ConstraintValidator<StatusCheck, String> {

    private Status[] statuses;

    @Override
    public void initialize(StatusCheck constraintAnnotation) {
        this.statuses = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

      if(StringUtils.isBlank(value))
      {
          return false;
      }

        for (Status status : statuses )
        {
            if (StringUtils.equals(status.getStatus(), value)) {
                return true;
            }
        }

        return false;

    }

}
