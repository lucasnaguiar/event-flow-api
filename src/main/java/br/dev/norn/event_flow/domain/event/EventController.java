package br.dev.norn.event_flow.domain.event;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.norn.event_flow.domain.event.dto.EventDetailDTO;
import br.dev.norn.event_flow.domain.event.dto.EventStoreDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService service;

    @PostMapping
    @Transactional
    public ResponseEntity<EventDetailDTO> create(@RequestBody @Valid EventStoreDTO data, UriComponentsBuilder uriBuilder){
        var event = service.create(data);
        var uri = uriBuilder.path("/events/{id}").buildAndExpand(event.getId()).toUri();
        return ResponseEntity.created(uri).body(new EventDetailDTO(event));
    }

    @GetMapping
    public ResponseEntity<Page<EventDetailDTO>> readAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        var page = service.readAll(pageable).map(EventDetailDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDetailDTO> readById(@PathVariable Long id){
        var event = service.readById(id);
        return ResponseEntity.ok(new EventDetailDTO(event));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EventDetailDTO> update(@PathVariable Long id, @RequestBody @Valid EventStoreDTO data){
        var event = service.update(id, data);
        return ResponseEntity.ok(new EventDetailDTO(event));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
