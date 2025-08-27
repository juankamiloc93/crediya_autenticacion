package com.crediya.autenticacion.infrastructure.entry_points;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crediya.autenticacion.domain.usecase.UsuarioUseCase;
import reactor.core.publisher.Mono;
import com.crediya.autenticacion.domain.model.Usuario;
import com.crediya.autenticacion.infrastructure.entry_points.dto.UsuarioRequest;
import com.crediya.autenticacion.infrastructure.mapper.MapperUsuario;

@Slf4j
@RestController
@RequestMapping("/api/v1/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final MapperUsuario mapperUsuario;

    private final UsuarioUseCase usuarioUseCase;

    @PostMapping
    public Mono<ResponseEntity<Usuario>> registrar(@RequestBody UsuarioRequest request) {
        Usuario usuario = mapperUsuario.toUsuario(request);
        return usuarioUseCase.registrar(usuario)
                .doOnSubscribe(sub -> log.info("Iniciando registro de usuario {}", request.correoElectronico()))
                .doOnSuccess(u -> log.info("Usuario {} registrado correctamente", u.getCorreoElectronico()))
                .doOnError(e -> log.error("Error registrando usuario", e))
                .map(u -> ResponseEntity.status(HttpStatus.CREATED).body(u));
    }
}
