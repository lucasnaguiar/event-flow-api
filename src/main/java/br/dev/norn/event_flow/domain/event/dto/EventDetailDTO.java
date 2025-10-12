package br.dev.norn.event_flow.domain.event.dto;

import br.dev.norn.event_flow.domain.category.dto.EventCategoryDetailDTO;
import br.dev.norn.event_flow.domain.event.Event;
import br.dev.norn.event_flow.domain.location.dto.EventLocationDetailDTO;
import br.dev.norn.event_flow.domain.user.dto.UserDetailDTO;

import java.time.LocalDateTime;

import java.math.BigDecimal;

public record EventDetailDTO(
        Long id,
        String name,
        String banner,
        String description,
        LocalDateTime eventDate,
        BigDecimal price,
        EventLocationDetailDTO location,
        EventCategoryDetailDTO category
) {
    public EventDetailDTO(Event event) {
        this(
                event.getId(),
                event.getName(),
                event.getBanner(),
                event.getDescription(),
                event.getEventDate(),
                event.getPrice(),
                new EventLocationDetailDTO(event.getLocation()),
                new EventCategoryDetailDTO(event.getCategory())
        );
    }
}
