package com.ecomerce.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


Schema(description = "Dados para alteração de senha")
public record ChangePasswordRequest(

         @Schema(example = "password123")
         @NotBlank(message = "Senha atual é obrigatória")
         String currentPassword,

         @Schema(example = "newpassword123")
         @NotBlank(message = "Nova senha é obrigatória")
         @Size(min = 8, message = "A nova senha deve conter no mínimo 8 caracteres")
         String newPassword
) {

}
