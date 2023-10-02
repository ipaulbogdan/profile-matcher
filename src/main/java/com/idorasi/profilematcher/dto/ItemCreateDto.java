package com.idorasi.profilematcher.dto;


import jakarta.validation.constraints.NotBlank;

public record ItemCreateDto(@NotBlank String name) {
}
