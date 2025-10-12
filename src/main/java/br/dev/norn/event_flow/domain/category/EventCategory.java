package br.dev.norn.event_flow.domain.category;

import jakarta.persistence.*;
import lombok.*;

import br.dev.norn.event_flow.domain.category.dto.EventCategoryStoreDTO;

@Table(name = "event_categories")
@Entity(name = "EventCategory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EventCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public EventCategory(EventCategoryStoreDTO data) {
        this.name = data.name();
    }

    public void update(EventCategoryStoreDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }
    }
}
