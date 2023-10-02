package com.idorasi.profilematcher.dto;

import jakarta.validation.constraints.NotBlank;

public record DeviceCreateDto(
        @NotBlank String model,
        @NotBlank String carrier,
        @NotBlank String firmware
) {
}
