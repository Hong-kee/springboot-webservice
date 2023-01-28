package com.harry.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Check if first sign up user for email.
    Optional<User> findByEmail(String email);

}
