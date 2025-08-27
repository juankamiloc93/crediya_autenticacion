package com.crediya.autenticacion.domain.usecase;

import com.crediya.autenticacion.domain.model.Usuario;
import com.crediya.autenticacion.domain.model.gateways.UsuarioGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public Mono<Usuario> registrar(Usuario usuario) {
        // aquí podrías encriptar la contraseña, validar email, etc.
        return usuarioGateway.guardar(usuario);
    }

    public Mono<Usuario> buscarPorCorreoElectronico(String correoElectronico){
        return usuarioGateway.buscarPorCorreoElectronico(correoElectronico);
    }
}
