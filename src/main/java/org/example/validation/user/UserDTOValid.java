package org.example.validation.user;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @author mazunin-sv
 * @version 08.05.2025 15:53
 */
@Constraint(validatedBy = UserDTOValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserDTOValid {

    String message() default "{UserRegisterDTO не прошел валидацию, не заполнен userName или password}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
