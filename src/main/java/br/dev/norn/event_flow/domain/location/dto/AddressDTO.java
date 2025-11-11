package br.dev.norn.event_flow.domain.location.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(
        @NotBlank
        String address,
        @NotBlank
        String city,
        String state
) {
}
