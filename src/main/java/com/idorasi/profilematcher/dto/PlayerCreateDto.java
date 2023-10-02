package com.idorasi.profilematcher.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record PlayerCreateDto(
        @NotBlank String credential,
        @NotBlank String country,
        @NotBlank String language,
        @NotNull LocalDate birthdate,
        @NotBlank String gender,
        @NotNull DeviceCreateDto device
) {}
