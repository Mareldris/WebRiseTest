package org.example.services;

import lombok.AllArgsConstructor;
import org.example.persistence.repositories.SubscriptionsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author mazunin-sv
 * @version 08.05.2025 23:44
 */
@AllArgsConstructor
class SubscriptionServiceTest {

    private SubscriptionsRepository subscriptionsRepository;
    private SubscriptionService subscriptionService;

    @BeforeEach
    void setUp() {
        subscriptionService = new SubscriptionService(subscriptionsRepository);
    }

    @Test
    void getTopThree() {

        System.out.println(subscriptionService.getTopThree());
    }
}