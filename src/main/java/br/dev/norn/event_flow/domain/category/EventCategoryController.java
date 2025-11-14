package br.dev.norn.event_flow.domain.category;

import br.dev.norn.event_flow.domain.category.dto.EventCategoryDetailDTO;
import br.dev.norn.event_flow.domain.category.dto.EventCategoryStoreDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class EventCategoryController {

    private final EventCategoryService eventCategoryService;

    @GetMapping
    public ResponseEntity<List<EventCategoryDetailDTO>> index()
    {
        return ResponseEntity.ok(eventCategoryService.getCategories());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EventCategoryDetailDTO> store(@RequestBody @Valid EventCategoryStoreDTO eventCategoryStoreDTO, UriComponentsBuilder uriBuilder)
    {
        var category = eventCategoryService.create(eventCategoryStoreDTO);
        var uri = uriBuilder.path("/categories/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(new EventCategoryDetailDTO(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventCategoryDetailDTO> readById(@PathVariable Long id) {
        var category = eventCategoryService.readById(id);
        return ResponseEntity.ok(new EventCategoryDetailDTO(category));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EventCategoryDetailDTO> update(@PathVariable Long id, @RequestBody @Valid EventCategoryStoreDTO data) {
        var category = eventCategoryService.update(id, data);
        return ResponseEntity.ok(new EventCategoryDetailDTO(category));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        eventCategoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
