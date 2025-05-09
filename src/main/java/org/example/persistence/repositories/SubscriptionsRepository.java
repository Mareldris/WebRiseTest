package org.example.persistence.repositories;

import org.example.models.subscription.SubscriptionTopResponseDTO;
import org.example.persistence.entities.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author mazunin-sv
 * @version 08.05.2025 13:00
 */
@Repository
public interface SubscriptionsRepository extends JpaRepository<SubscriptionEntity, Long> {


        @Query(value = """
            select subscription, count(subscription) top
              from subscriptions
              where is_active = true
              group by subscription
              order by top desc
              limit 3
            """, nativeQuery = true)
    Set<SubscriptionTopResponseDTO> findTopThreeSubscription();
}
