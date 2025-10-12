package br.dev.norn.event_flow.domain.event;

import br.dev.norn.event_flow.domain.category.EventCategory;
import br.dev.norn.event_flow.domain.location.EventLocation;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.dev.norn.event_flow.domain.event.dto.EventStoreDTO;

@Table(name = "events")
@Entity(name = "Event")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String banner;

    private String description;

    private LocalDateTime eventDate;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "event_category_id")
    private EventCategory category;

    @ManyToOne
    @JoinColumn(name = "event_location_id")
    private EventLocation location;

    public Event(EventStoreDTO data, EventLocation location, EventCategory category) {
        this.name = data.name();
        this.banner = data.banner();
        this.description = data.description();
        this.eventDate = data.eventDate();
        this.price = data.price();
        this.location = location;
        this.category = category;
    }

    public void update(EventStoreDTO data, EventLocation location, EventCategory category) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.banner() != null) {
            this.banner = data.banner();
        }
        if (data.description() != null) {
            this.description = data.description();
        }
        if (data.eventDate() != null) {
            this.eventDate = data.eventDate();
        }
        if (data.price() != null) {
            this.price = data.price();
        }
        if (location != null) {
            this.location = location;
        }
        if (category != null) {
            this.category = category;
        }
    }
}