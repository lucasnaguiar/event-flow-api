package br.dev.norn.event_flow.domain.category.dto;

import jakarta.validation.constraints.NotBlank;

public record EventCategoryStoreDTO(
        @NotBlank
        String name
) {
}
