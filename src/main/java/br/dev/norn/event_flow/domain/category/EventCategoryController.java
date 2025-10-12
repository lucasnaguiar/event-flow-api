package br.dev.norn.event_flow.domain.category;

import br.dev.norn.event_flow.domain.category.dto.EventCategoryDetailDTO;
import br.dev.norn.event_flow.domain.category.dto.EventCategoryStoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class EventCategoryController {

    @Autowired
    private EventCategoryService eventCategoryService;

    @GetMapping
    public ResponseEntity<List<EventCategoryDetailDTO>> index()
    {
        return ResponseEntity.ok(eventCategoryService.getCategories());
    }

    @PostMapping
    public ResponseEntity<EventCategoryDetailDTO> store(@RequestBody EventCategoryStoreDTO eventCategoryStoreDTO)
    {
        var category = eventCategoryService.create(eventCategoryStoreDTO);
        return new ResponseEntity<EventCategoryDetailDTO>(new EventCategoryDetailDTO(category), HttpStatus.CREATED);
    }
}
