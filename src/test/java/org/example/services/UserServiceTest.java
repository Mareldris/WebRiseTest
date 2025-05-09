package org.example.services;

import org.example.mappers.SubscriptionMapper;
import org.example.mappers.UserMapper;
import org.example.mappers.UserMapperImpl;
import org.example.models.subscription.Subscriptions;
import org.example.models.user.UserRegisterDTO;
import org.example.persistence.entities.SubscriptionEntity;
import org.example.persistence.entities.UserEntity;
import org.example.persistence.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * @author mazunin-sv
 * @version 08.05.2025 15:44
 */

class UserServiceTest {

    private UserService userService;

    private UserRepository userRepository;

    private UserMapper userMapper;

    @BeforeEach
    void setUp() {

        userRepository = mock(UserRepository.class);
        userMapper = new UserMapperImpl();
        userService = new UserService(userRepository, userMapper, mock(SubscriptionMapper.class));
    }

    @Test
    void register() {

        UserRegisterDTO registerDTO = new UserRegisterDTO();
        registerDTO.setFio("fio");
        userService.register(registerDTO);
    }

    @Test
    void getUser() {

        UserEntity userEntity = new UserEntity();
        Set<SubscriptionEntity> seSet = new HashSet<>();
        seSet.add(new SubscriptionEntity(0L, Subscriptions.NETFLIX, ZonedDateTime.now().plusMonths(1), new UserEntity(), true));
        seSet.add(new SubscriptionEntity(1L, Subscriptions.YANDEX_PLUS, ZonedDateTime.now().plusMonths(3), new UserEntity(), true));
        seSet.add(new SubscriptionEntity(2L, Subscriptions.YOUTUBE_PREMIUM, ZonedDateTime.now().plusMonths(5), new UserEntity(), true));
        seSet.add(new SubscriptionEntity(3L, Subscriptions.VK_MUSIC, ZonedDateTime.now().plusMonths(11), new UserEntity(), true));

        userEntity.setSubscriptions(seSet);

        System.out.println(seSet);
        SubscriptionEntity se = userEntity.getSubscriptions().stream()
                .filter(s -> s.getId().equals(0L))
                .findFirst().orElse(null);

        SubscriptionEntity se1 = userEntity.getSubscriptions().stream()
                .filter(s -> s.getId().equals(2L))
                .findFirst().orElse(null);
        se.setActive(false);
        se1.setActive(false);

        seSet.add(se);
        seSet.add(se1);
        System.out.println(seSet.stream().filter(s -> s.getId().equals(0L)).findFirst().orElse(null).isActive());
        System.out.println(seSet.stream().filter(s -> s.getId().equals(2L)).findFirst().orElse(null).isActive());
    }

    @Test
    void update() {
    }
}