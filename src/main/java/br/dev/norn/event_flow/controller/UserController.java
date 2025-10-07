package br.dev.norn.event_flow.controller;

import br.dev.norn.event_flow.dto.user.UserDetailDTO;
import br.dev.norn.event_flow.dto.user.UserRegisterDTO;
import br.dev.norn.event_flow.service.UserService;
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
