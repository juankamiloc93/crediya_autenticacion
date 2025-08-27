package com.crediya.autenticacion.infrastructure.driver_dapter.postgresRepository;

import com.crediya.autenticacion.domain.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.crediya.autenticacion.domain.model.gateways.UsuarioGateway;
import com.crediya.autenticacion.infrastructure.mapper.MapperUsuario;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UsuarioDataRepositoryGatewayImpl implements UsuarioGateway{

    private final MapperUsuario mapperUsuario;

    private final UsuarioDataRepository repository;

    @Override
    public Mono<Usuario> guardar(Usuario usuario) {
        UsuarioData usuarioData = mapperUsuario.toData(usuario);
        return repository.save(usuarioData).map(mapperUsuario::toUsuario);
    }

    @Override
    public Mono<Usuario> buscarPorCorreoElectronico(String correoElectronico) {
        return repository.findBycorreoElectronico(correoElectronico).map(mapperUsuario::toUsuario);
    }
}
