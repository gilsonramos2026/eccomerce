package com.ecomerce.backend.entity;

import java.time.LocalDateTime;

import com.ecomerce.backend.entity.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   //Nome completo do usuário
   @Column(nullable = false)
   private String name;

   // Email usado no login com senha e no Google.
   @Column(nullable = false, unique = true)
   private String email;

   // Senha criptografada com BCrypt.
   private String password;

   // Telefone usado no login por SMS.
   @Column(unique = true)
   private String phone;

   // Papel do usuário: ROLE_USER, ROLE_ADMIN, etc.
   @Enumerated(EnumType.STRING)
   @Column(nullable = false)
   private Role role;

   // Indica se o usuário está ativo ou não.
   @Column(nullable = false)
   private Boolean enabled;

   // Data de criação do usuário.
   @Column(nullable = false)
   private LocalDateTime createdAt;
}
