package org.example.validation.user;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.models.user.UserRegisterDTO;

/**
 * @author mazunin-sv
 * @version 08.05.2025 15:52
 */
public class UserDTOValidator implements ConstraintValidator<UserDTOValid, UserRegisterDTO> {
    @Override
    public boolean isValid(UserRegisterDTO dto, ConstraintValidatorContext context) {

        if (dto == null) {
            return false;
        }

        if (dto.getUsername() == null || dto.getUsername().trim().isEmpty()) {
            return false;
        }

        return dto.getPassword() != null && !dto.getPassword().trim().isEmpty();
    }
}
