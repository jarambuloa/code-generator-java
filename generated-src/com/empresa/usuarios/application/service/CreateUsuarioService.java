
package com.empresa.usuarios.application.service;

import com.empresa.usuarios.application.port.in.CreateUsuarioUseCase;
import com.empresa.usuarios.application.port.out.UsuarioRepositoryPort;
import com.empresa.usuarios.domain.model.Usuario;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateUsuarioService implements CreateUsuarioUseCase {

    private final UsuarioRepositoryPort repository;

    public CreateUsuarioService(UsuarioRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Usuario create(Usuario usuario) {
        return repository.save(usuario);
    }
}
