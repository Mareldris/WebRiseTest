package org.example.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * @author mazunin-sv
 * @version 07.05.2025 18:55
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fio")
    private String fio;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<SubscriptionEntity> subscriptions;

}
