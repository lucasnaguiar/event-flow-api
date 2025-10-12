package br.dev.norn.event_flow.domain.location;

import br.dev.norn.event_flow.domain.location.dto.EventLocationDetailDTO;
import br.dev.norn.event_flow.domain.location.dto.EventLocationStoreDTO;
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
@RequestMapping("/locations")
@RequiredArgsConstructor
public class EventLocationController {

    private final EventLocationService service;

    @PostMapping
    @Transactional
    public ResponseEntity<EventLocationDetailDTO> create(@RequestBody @Valid EventLocationStoreDTO data, UriComponentsBuilder uriBuilder){
        var location = service.create(data);
        var uri = uriBuilder.path("/locations/{id}").buildAndExpand(location.getId()).toUri();
        return ResponseEntity.created(uri).body(new EventLocationDetailDTO(location));
    }

    @GetMapping
    public ResponseEntity<Page<EventLocationDetailDTO>> readAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        var page = service.readAll(pageable).map(EventLocationDetailDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventLocationDetailDTO> readById(@PathVariable Long id){
        var location = service.readById(id);
        return ResponseEntity.ok(new EventLocationDetailDTO(location));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EventLocationDetailDTO> update(@PathVariable Long id, @RequestBody @Valid EventLocationStoreDTO data){
        var location = service.update(id, data);
        return ResponseEntity.ok(new EventLocationDetailDTO(location));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
