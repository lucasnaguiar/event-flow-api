package br.dev.norn.event_flow.domain.category;

import br.dev.norn.event_flow.domain.category.dto.EventCategoryDetailDTO;
import br.dev.norn.event_flow.domain.category.dto.EventCategoryStoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventCategoryService {

    private final EventCategoryRepository eventCategoryRepository;

    public List<EventCategoryDetailDTO> getCategories() {
       return eventCategoryRepository.findAll().stream().map(EventCategoryDetailDTO::new).toList();
    }

    public EventCategory create(EventCategoryStoreDTO eventCategoryStoreDTO) {
        var eventCategory = new EventCategory(eventCategoryStoreDTO);
        return eventCategoryRepository.save(eventCategory);
    }

}
