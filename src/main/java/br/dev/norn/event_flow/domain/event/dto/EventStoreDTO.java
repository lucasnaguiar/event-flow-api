package br.dev.norn.event_flow.domain.event.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

import java.math.BigDecimal;

public record EventStoreDTO(
        @NotBlank
        String name,
        @NotBlank
        String banner,
        @NotBlank
        String description,
        @NotNull
        @Future
        LocalDateTime eventDate,
        BigDecimal price,
        @NotNull
        Long locationId,
        @NotNull
        Long categoryId
) {
}
