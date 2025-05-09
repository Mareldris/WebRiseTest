package org.example.persistence.repositories;

import org.example.models.user.User;
import org.example.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mazunin-sv
 * @version 07.05.2025 18:58
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = """
      select *
      from users
      where lower(username) = lower(?)
      """, nativeQuery = true)
    List<User> findByUsernameIgnoreCase(String username);

}
