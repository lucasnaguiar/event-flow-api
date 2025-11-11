package br.dev.norn.event_flow.domain.location.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EventLocationStoreDTO(
        @NotBlank
        String name,
        @NotNull
        Double latitude,
        @NotNull
        Double longitude,
        Boolean hasAddress,
        @Valid
        AddressDTO address
) {
}
