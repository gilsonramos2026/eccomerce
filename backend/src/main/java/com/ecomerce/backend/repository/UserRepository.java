package com.ecomerce.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> findByEmail(String email);

   Optional<User> findByPhone(String phone);

   Optional<User> existsByEmail(String email);

   boolean existsByPhone(String phone);

}
