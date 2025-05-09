package org.example.persistence.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.models.subscription.Subscriptions;

import java.time.ZonedDateTime;

/**
 * @author mazunin-sv
 * @version 07.05.2025 18:59
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "subscriptions")
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Subscriptions subscription;

    @Column(name = "end_date_time")
    private ZonedDateTime endDateTime;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @Column(name = "is_active")
    boolean isActive;

}
