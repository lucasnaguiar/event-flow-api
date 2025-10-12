package br.dev.norn.event_flow.domain.user;

import br.dev.norn.event_flow.domain.user.dto.UserDetailDTO;
import br.dev.norn.event_flow.domain.user.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public List<UserDetailDTO> getUsers() {
        return userRepository.findAll().stream().map(UserDetailDTO::new).toList();
    }

    public void store(UserRegisterDTO user) {
        var userEntity = new User();
        userEntity.setName(user.name());
        userEntity.setEmail(user.email());
        userEntity.setPassword(passwordEncoder.encode(user.password()));
        userRepository.save(userEntity);
    }
}
