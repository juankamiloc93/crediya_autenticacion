package com.crediya.autenticacion.application.config;

import com.crediya.autenticacion.domain.model.gateways.UsuarioGateway;
import com.crediya.autenticacion.domain.usecase.UsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public UsuarioUseCase usuarioUseCase(UsuarioGateway usuarioGateway){
        return new UsuarioUseCase(usuarioGateway);
    }
}