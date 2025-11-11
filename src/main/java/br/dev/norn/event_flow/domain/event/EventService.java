package br.dev.norn.event_flow.domain.event;

import br.dev.norn.event_flow.config.FileStorageService;
import br.dev.norn.event_flow.domain.category.EventCategoryRepository;
import br.dev.norn.event_flow.domain.event.dto.EventStoreDTO;
import br.dev.norn.event_flow.domain.location.EventLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventLocationRepository locationRepository;
    private final EventCategoryRepository categoryRepository;
    private final FileStorageService fileStorageService;

    public Event create(EventStoreDTO data, MultipartFile bannerFile) {
        var location = locationRepository.getReferenceById(data.locationId());
        var category = categoryRepository.getReferenceById(data.categoryId());

        // Processar upload de imagem se fornecido
        String bannerPath = null;
        if (bannerFile != null && !bannerFile.isEmpty()) {
            bannerPath = fileStorageService.storeFile(bannerFile);
        }

        // Criar novo DTO com o caminho do arquivo
        var eventData = new EventStoreDTO(
                data.name(),
                bannerPath,
                data.description(),
                data.eventDate(),
                data.price(),
                data.locationId(),
                data.categoryId()
        );

        var event = new Event(eventData, location, category);
        return eventRepository.save(event);
    }

    public Page<Event> readAll(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    public Event readById(Long id) {
        return eventRepository.getReferenceById(id);
    }

    public Event update(Long id, EventStoreDTO data, MultipartFile bannerFile) {
        var event = eventRepository.getReferenceById(id);
        var location = data.locationId() != null ? locationRepository.getReferenceById(data.locationId()) : null;
        var category = data.categoryId() != null ? categoryRepository.getReferenceById(data.categoryId()) : null;

        // Processar upload de nova imagem se fornecido
        String bannerPath = data.banner();
        if (bannerFile != null && !bannerFile.isEmpty()) {
            // Deletar arquivo antigo se existir
            if (event.getBanner() != null) {
                fileStorageService.deleteFile(event.getBanner());
            }
            bannerPath = fileStorageService.storeFile(bannerFile);
        }

        // Criar novo DTO com o caminho do arquivo atualizado
        var eventData = new EventStoreDTO(
                data.name(),
                bannerPath,
                data.description(),
                data.eventDate(),
                data.price(),
                data.locationId(),
                data.categoryId()
        );

        event.update(eventData, location, category);
        return event;
    }

    public void delete(Long id) {
        var event = eventRepository.getReferenceById(id);

        // Deletar arquivo de imagem se existir
        if (event.getBanner() != null) {
            fileStorageService.deleteFile(event.getBanner());
        }

        eventRepository.deleteById(id);
    }
}
