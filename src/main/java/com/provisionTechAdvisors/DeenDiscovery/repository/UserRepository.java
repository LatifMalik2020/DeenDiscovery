package com.provisionTechAdvisors.DeenDiscovery.repository;

import com.provisionTechAdvisors.DeenDiscovery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Find by username
    Optional<User> findByUsername(String username);

    // Find by ID is already provided by JpaRepository, but you can explicitly define it if needed
    Optional<User> findById(Long id);
    User findByEmail(String email);
}
