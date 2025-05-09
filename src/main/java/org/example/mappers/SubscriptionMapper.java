package org.example.mappers;

import org.example.models.subscription.Subscription;
import org.example.persistence.entities.SubscriptionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

/**
 * @author mazunin-sv
 * @version 09.05.2025 16:47
 */
@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubscriptionMapper {

    Set<Subscription> mapToSubscription( Set<SubscriptionEntity> subscriptions);
}
