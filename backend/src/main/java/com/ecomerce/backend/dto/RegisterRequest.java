package com.ecomerce.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados para cadastro de um novo usuário")
public record RegisterRequest(

         @Schema(example = "John Doe")
         @NotBlank(message = "Nome é obrigatório")
         String name,

         @Schema(example = "john.doe@example.com")
         @NotBlank(message = "Email é obrigatório")
         String email,

         @Schema(example = "11999999999")
         @NotBlank(message = "Telefone é obrigatório")
         String phone,
         
         @Schema(example = "password123")
         @NotBlank(message = "Senha é obrigatória")
         @Size(min = 8, message = "A senha deve conter no mínimo 8 caracteres")
         String password
) {

}
