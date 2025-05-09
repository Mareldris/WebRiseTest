package org.example.services;

import lombok.AllArgsConstructor;
import org.example.models.subscription.SubscriptionTopResponseDTO;
import org.example.persistence.repositories.SubscriptionsRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author mazunin-sv
 * @version 08.05.2025 22:12
 */
@Service
@AllArgsConstructor
public class SubscriptionService {

    private final SubscriptionsRepository subscriptionsRepository;

    public Set<SubscriptionTopResponseDTO> getTopThree() {

            return subscriptionsRepository.findTopThreeSubscription();

    }
}
