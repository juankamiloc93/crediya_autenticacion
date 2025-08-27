package com.crediya.autenticacion.domain.model.gateways;

import com.crediya.autenticacion.domain.model.Usuario;
import reactor.core.publisher.Mono;

public interface UsuarioGateway {
    Mono<Usuario> guardar(Usuario usuario);
    Mono<Usuario> buscarPorCorreoElectronico(String email);
}
