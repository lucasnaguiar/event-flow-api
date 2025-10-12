package br.dev.norn.event_flow.domain.location;

import jakarta.persistence.*;
import lombok.*;

import br.dev.norn.event_flow.domain.location.dto.EventLocationStoreDTO;

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

    public EventLocation(EventLocationStoreDTO data) {
        this.name = data.name();
        this.latitude = data.latitude();
        this.longitude = data.longitude();
        this.hasAddress = data.hasAddress();
        this.address = data.address();
        this.city = data.city();
        this.state = data.state();
        this.country = data.country();
        this.zipCode = data.zipCode();
    }

    public void update(EventLocationStoreDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.latitude() != null) {
            this.latitude = data.latitude();
        }
        if (data.longitude() != null) {
            this.longitude = data.longitude();
        }
        if (data.hasAddress() != null) {
            this.hasAddress = data.hasAddress();
        }
        if (data.address() != null) {
            this.address = data.address();
        }
        if (data.city() != null) {
            this.city = data.city();
        }
        if (data.state() != null) {
            this.state = data.state();
        }
        if (data.country() != null) {
            this.country = data.country();
        }
        if (data.zipCode() != null) {
            this.zipCode = data.zipCode();
        }
    }
}
