package com.franco.ForoHUB.domain.usuario;

import aj.org.objectweb.asm.Opcodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByLogin(String login);
    Optional<Usuario> findById (Long id);
}
