package br.dev.norn.event_flow.domain.user.dto;

import br.dev.norn.event_flow.domain.user.User;

public record UserDetailDTO (Long id, String name, String email) {
    public UserDetailDTO (User user) {
        this(
            user.getId(),
            user.getName(),
            user.getEmail()
        );
    }
}
