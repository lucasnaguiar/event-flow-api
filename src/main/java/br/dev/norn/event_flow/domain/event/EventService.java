package br.dev.norn.event_flow.domain.event;

import br.dev.norn.event_flow.domain.category.EventCategoryRepository;
import br.dev.norn.event_flow.domain.event.dto.EventStoreDTO;
import br.dev.norn.event_flow.domain.location.EventLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventLocationRepository locationRepository;
    private final EventCategoryRepository categoryRepository;

    public Event create(EventStoreDTO data) {
        var location = locationRepository.getReferenceById(data.locationId());
        var category = categoryRepository.getReferenceById(data.categoryId());

        var event = new Event(data, location, category);
        return eventRepository.save(event);
    }

    public Page<Event> readAll(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    public Event readById(Long id) {
        return eventRepository.getReferenceById(id);
    }

    public Event update(Long id, EventStoreDTO data) {
        var event = eventRepository.getReferenceById(id);
        var location = data.locationId() != null ? locationRepository.getReferenceById(data.locationId()) : null;
        var category = data.categoryId() != null ? categoryRepository.getReferenceById(data.categoryId()) : null;

        event.update(data, location, category);
        return event;
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
