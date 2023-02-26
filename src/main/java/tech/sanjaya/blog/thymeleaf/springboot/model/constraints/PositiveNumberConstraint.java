package tech.sanjaya.blog.thymeleaf.springboot.model.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import tech.sanjaya.blog.thymeleaf.springboot.model.constraints.Validators.PositiveNumberValidator;

@Documented
@Constraint(validatedBy = PositiveNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PositiveNumberConstraint {
    String message() default "Invalid Number, Should be greater than zero";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}