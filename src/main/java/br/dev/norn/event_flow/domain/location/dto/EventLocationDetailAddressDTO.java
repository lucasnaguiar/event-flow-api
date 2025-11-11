package br.dev.norn.event_flow.domain.location.dto;

import br.dev.norn.event_flow.domain.location.EventLocation;

public record EventLocationDetailAddressDTO(
        String address,
        String city,
        String state
) {
    public EventLocationDetailAddressDTO(EventLocation location) {
        this(
                location.getAddress(),
                location.getCity(),
                location.getState()
        );
    }
}