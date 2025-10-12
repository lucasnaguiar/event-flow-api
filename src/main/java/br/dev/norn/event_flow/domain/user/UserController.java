package br.dev.norn.event_flow.domain.user;

import br.dev.norn.event_flow.domain.user.dto.UserDetailDTO;
import br.dev.norn.event_flow.domain.user.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDetailDTO>> index() {
        var users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody UserRegisterDTO userRegisterDTO) {
        userService.store(userRegisterDTO);

        return ResponseEntity.ok().build();
    }
}
