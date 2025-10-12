package br.dev.norn.event_flow.domain.category;

import br.dev.norn.event_flow.domain.category.dto.EventCategoryDetailDTO;
import br.dev.norn.event_flow.domain.category.dto.EventCategoryStoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<EventCategoryDetailDTO> store(@RequestBody EventCategoryStoreDTO eventCategoryStoreDTO, UriComponentsBuilder uriBuilder)
    {
        var category = eventCategoryService.create(eventCategoryStoreDTO);
        var uri = uriBuilder.path("/categories/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(new EventCategoryDetailDTO(category));
    }
}
