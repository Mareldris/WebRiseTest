package org.example.services;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.exceptions.BusinessException;
import org.example.mappers.SubscriptionMapper;
import org.example.mappers.UserMapper;
import org.example.models.ErrorType;
import org.example.models.subscription.Subscription;
import org.example.models.subscription.SubscriptionDTO;
import org.example.models.user.User;
import org.example.models.user.UserRegisterDTO;
import org.example.models.user.UserUpdateDTO;
import org.example.persistence.entities.SubscriptionEntity;
import org.example.persistence.entities.UserEntity;
import org.example.persistence.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

/**
 * @author mazunin-sv
 * @version 08.05.2025 13:18
 */
@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final SubscriptionMapper subscriptionMapper;

    public void register(@Valid UserRegisterDTO dto) {

        List<User> userList = userRepository.findByUsernameIgnoreCase(dto.getUsername());

        if (!userList.isEmpty()) {
            throw new BusinessException(ErrorType.USER_IS_FOUND.getMessage().formatted(dto.getUsername()),
                    HttpStatus.BAD_REQUEST,
                    ErrorType.USER_IS_FOUND.name());
        }

        UserEntity userEntity = userMapper.mapFromRegisterDto(dto);

        userRepository.save(userEntity);
    }

    public User getUser(Long id) {

        UserEntity userEntity = findUserById(id);

        return userMapper.map(userEntity);
    }

    public void update(@Valid UserUpdateDTO dto) {

        UserEntity userEntity = findUserById(dto.getId());

        boolean isUsernameUpdated = dto.getUsername() != null;
        boolean isPasswordUpdated = dto.getPassword() != null;
        boolean isFioUpdated = dto.getFio() != null;

        if (!isUsernameUpdated
                && !isPasswordUpdated
                && !isFioUpdated){
            return;
        }

        log.info("Updating user: {}, new user info: {} ", userEntity, dto);
        if (isUsernameUpdated && StringUtils.hasText(dto.getUsername())) {
            userEntity.setUsername(dto.getUsername());
        }
        if (isPasswordUpdated && StringUtils.hasText(dto.getPassword())) {
            userEntity.setPassword(dto.getPassword());
        }
        if (isFioUpdated && StringUtils.hasText(dto.getFio())) {
            userEntity.setFio(dto.getFio());
        }

        userRepository.save(userEntity);
    }

    public void delete(Long id) {
        UserEntity userEntity = findUserById(id);
        log.info("Deleting user: {}", userEntity);
        userRepository.delete(userEntity);
    }

    private UserEntity findUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity == null) {
            log.error("User not found: {}", id);
            throw new BusinessException(ErrorType.USER_IS_NOT_FOUND.getMessage().formatted(id),
                    HttpStatus.BAD_REQUEST,
                    ErrorType.USER_IS_NOT_FOUND.name());
        }

        return userEntity;
    }

    public void addSubscription(@Valid SubscriptionDTO dto) {
        UserEntity userEntity = findUserById(dto.getUserId());
        SubscriptionEntity se = userEntity.getSubscriptions().stream()
                .filter(s-> s.getSubscription().equals(dto.getSubscription()))
                .findFirst().orElse(null);

        if (se == null) {
            se = new SubscriptionEntity();
            se.setUser(userEntity);
            se.setSubscription(dto.getSubscription());
            se.setEndDateTime(ZonedDateTime.now().plusMonths(dto.getMonth()));
        }else {
            se.setEndDateTime(se.getEndDateTime().plusMonths(dto.getMonth()));
        }

        userEntity.getSubscriptions().add(se);
        userRepository.save(userEntity);

    }

    public Set<Subscription> getSubscriptions(Long id) {
        UserEntity userEntity = findUserById(id);
        return subscriptionMapper.mapToSubscription(userEntity.getSubscriptions());
    }

    public void unsubscribe(Long userId, Long subId) {
        UserEntity userEntity = findUserById(userId);

        SubscriptionEntity se = userEntity.getSubscriptions().stream()
                .filter(s -> s.getId().equals(subId))
                .findFirst()
                .orElseThrow(() -> new BusinessException(ErrorType.SUBSCRIPTION_NOT_FOUND.getMessage().formatted(subId),
                        HttpStatus.UNPROCESSABLE_ENTITY, ErrorType.SUBSCRIPTION_NOT_FOUND.name()));

        se.setActive(false);
        userEntity.getSubscriptions().add(se);
        userRepository.save(userEntity);
    }
}
