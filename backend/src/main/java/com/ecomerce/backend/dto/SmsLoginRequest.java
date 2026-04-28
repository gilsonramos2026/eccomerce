package com.ecomerce.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Dados para login via SMS")
public record SmsLoginRequest(

         @Schema(example = "11999999999")
         @NotBlank(message = "Telefone é obrigatório")
         String phone,

         @Schema(example = "123456")
         @NotBlank(message = "Código de verificação é obrigatório")
         String verificationCode
) {

}
