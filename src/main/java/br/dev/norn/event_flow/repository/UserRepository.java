package br.dev.norn.event_flow.repository;

import br.dev.norn.event_flow.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
}
