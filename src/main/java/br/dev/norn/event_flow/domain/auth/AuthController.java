package br.dev.norn.event_flow.domain.auth;

import br.dev.norn.event_flow.domain.user.User;
import br.dev.norn.event_flow.domain.auth.dto.LoginDTO;
import br.dev.norn.event_flow.domain.auth.dto.TokenDataObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("login")
    public ResponseEntity<TokenDataObject> login(@RequestBody LoginDTO loginDTO) {
        var authObject = new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password());

        var auth = authenticationManager.authenticate(authObject);
        var userToken = authService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new TokenDataObject(userToken));
    }
}
