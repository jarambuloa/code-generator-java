
package com.empresa.usuarios.adapters.in.rest;

import com.empresa.usuarios.application.port.in.CreateUsuarioUseCase;
import com.empresa.usuarios.adapters.in.rest.dto.CreateUsuarioRequest;
import com.empresa.usuarios.domain.model.Usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CreateUsuarioUseCase createUseCase;

    public UsuarioController(CreateUsuarioUseCase createUseCase) {
        this.createUseCase = createUseCase;
    }

    @PostMapping
    public ResponseEntity<Usuario> create(
            @RequestBody CreateUsuarioRequest request) {

        Usuario created = createUseCase.create(
                new Usuario(

                    request.getUsername(),

                    request.getEmail()

                )
        );

        return ResponseEntity.ok(created);
    }
}
