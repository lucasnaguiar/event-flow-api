package br.dev.norn.event_flow.domain.category;

import jakarta.persistence.*;
import lombok.*;

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
}
