package com.ms.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UUID;

public record UserRecord(@NotBlank String name,
                         @NotBlank @Email String email) { }

