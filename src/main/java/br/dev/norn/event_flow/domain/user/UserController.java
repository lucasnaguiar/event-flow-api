package br.dev.norn.event_flow.domain.user;

import br.dev.norn.event_flow.domain.user.dto.UserDetailDTO;
import br.dev.norn.event_flow.domain.user.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDetailDTO>> index() {
        var users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDetailDTO> create(@RequestBody UserRegisterDTO userRegisterDTO, UriComponentsBuilder uriBuilder) {
        var user = userService.store(userRegisterDTO);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailDTO(user));
    }
}
