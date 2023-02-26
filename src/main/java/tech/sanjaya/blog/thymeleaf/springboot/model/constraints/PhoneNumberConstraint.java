package tech.sanjaya.blog.thymeleaf.springboot.model.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import tech.sanjaya.blog.thymeleaf.springboot.model.constraints.Validators.PhoneNumberValidator;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumberConstraint {
    String message() default "Invalid Phone Number, valid formats are 123-456-7890, (123) 456-7890, 123 456 7890, 123.456.7890, +91 (123) 456-7890";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}