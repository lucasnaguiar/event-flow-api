package br.dev.norn.event_flow.domain.event.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public record EventFormDTO(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        @Future
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime eventDate,
        BigDecimal price,
        @NotNull
        Long locationId,
        @NotNull
        Long categoryId
) {
    public EventStoreDTO toStoreDTO(String bannerPath) {
        return new EventStoreDTO(
                name,
                bannerPath,
                description,
                eventDate,
                price,
                locationId,
                categoryId
        );
    }
}
