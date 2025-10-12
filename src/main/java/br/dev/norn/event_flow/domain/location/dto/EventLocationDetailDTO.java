package br.dev.norn.event_flow.domain.location.dto;

import br.dev.norn.event_flow.domain.location.EventLocation;

public record EventLocationDetailDTO(
        Long id,
        String name,
        Double latitude,
        Double longitude,
        Boolean hasAddress,
        EventLocationDetailAddressDTO address
) {
    public EventLocationDetailDTO(EventLocation location) {
        this(
                location.getId(),
                location.getName(),
                location.getLatitude(),
                location.getLongitude(),
                location.getHasAddress(),
                location.getHasAddress() ? new EventLocationDetailAddressDTO(location) : null
        );
    }
}
