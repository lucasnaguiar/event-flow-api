package br.dev.norn.event_flow.domain.event;

import br.dev.norn.event_flow.domain.category.EventCategory;
import br.dev.norn.event_flow.domain.location.EventLocation;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
}