package org.example.mappers;

import org.example.models.user.User;
import org.example.models.user.UserRegisterDTO;
import org.example.persistence.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * @author mazunin-sv
 * @version 08.05.2025 13:32
 */

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {


    UserEntity mapFromRegisterDto(UserRegisterDTO userRegisterDTO);

    User map(UserEntity userEntity);
}
