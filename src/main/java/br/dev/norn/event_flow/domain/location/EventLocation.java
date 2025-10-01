package br.dev.norn.event_flow.domain.location;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "event_locations")
@Entity(name = "EventLocation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EventLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double latitude;

    private Double longitude;

    private Boolean hasAddress;

    private String address;

    private String city;

    private String state;

    private String country;

    private String zipCode;
}
