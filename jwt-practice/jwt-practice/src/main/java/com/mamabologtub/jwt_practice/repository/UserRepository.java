package com.mamabologtub.jwt_practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mamabologtub.jwt_practice.Entity.User;


/**
 * @Author Tshepo M Mahudu on Jan 17, 2025.
 */

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

}
