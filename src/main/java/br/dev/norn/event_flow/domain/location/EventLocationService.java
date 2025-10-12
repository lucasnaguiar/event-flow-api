package br.dev.norn.event_flow.domain.location;

import br.dev.norn.event_flow.domain.location.dto.EventLocationStoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventLocationService {

    private final EventLocationRepository repository;

    public EventLocation create(EventLocationStoreDTO data) {
        var location = new EventLocation(data);
        return repository.save(location);
    }

    public Page<EventLocation> readAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public EventLocation readById(Long id) {
        return repository.getReferenceById(id);
    }

    public EventLocation update(Long id, EventLocationStoreDTO data) {
        var location = repository.getReferenceById(id);
        location.update(data);
        return location;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
