package br.dev.norn.event_flow.domain.user;

import br.dev.norn.event_flow.domain.user.dto.UserDetailDTO;
import br.dev.norn.event_flow.domain.user.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public List<UserDetailDTO> getUsers() {
        return userRepository.findAll().stream().map(UserDetailDTO::new).toList();
    }

    public User store(UserRegisterDTO userDTO) {
        var userEntity = new User(userDTO);
        userEntity.setPassword(passwordEncoder.encode(userDTO.password()));
        return userRepository.save(userEntity);
    }
}
