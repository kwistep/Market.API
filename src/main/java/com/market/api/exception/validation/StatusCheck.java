package com.market.api.exception.validation;

import com.market.api.entity.util.Status;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = StatusCheckValidator.class)
@Documented
public @interface StatusCheck {

    String message() default "{com.market.api.exception.validation." +
            "message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    Status[] value();

    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Status[] value();
    }

}
