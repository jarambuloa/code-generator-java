
package com.empresa.usuarios.application.port.in;

import com.empresa.usuarios.domain.model.Usuario;

public interface CreateUsuarioUseCase {

    Usuario create(Usuario usuario);
}
