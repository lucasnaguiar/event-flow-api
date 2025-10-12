package br.dev.norn.event_flow.domain.category.dto;

import br.dev.norn.event_flow.domain.category.EventCategory;

public record EventCategoryDetailDTO(Long id, String name) {
    public EventCategoryDetailDTO(EventCategory eventCategory){
        this(
            eventCategory.getId(),
            eventCategory.getName()
        );
    }
}
