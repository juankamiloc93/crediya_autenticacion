package com.crediya.autenticacion.infrastructure.driver_dapter.postgresRepository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UsuarioDataRepository extends ReactiveCrudRepository<UsuarioData, Integer> {
    Mono<UsuarioData> findBycorreoElectronico(String CorreoElectronico);
}
