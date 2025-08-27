package com.crediya.autenticacion.infrastructure.mapper;

import com.crediya.autenticacion.domain.model.Usuario;
import com.crediya.autenticacion.infrastructure.driver_dapter.postgresRepository.UsuarioData;
import com.crediya.autenticacion.infrastructure.entry_points.dto.UsuarioRequest;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class MapperUsuario {
    public Usuario toUsuario(UsuarioData usuarioData){
        return new Usuario(
                usuarioData.getId(),
                usuarioData.getNombres(),
                usuarioData.getApellidos(),
                usuarioData.getFechaNacimiento(),
                usuarioData.getDireccion(),
                usuarioData.getTelefono(),
                usuarioData.getCorreoElectronico(),
                usuarioData.getSalarioBase()
        );
    }

    public Usuario toUsuario(UsuarioRequest usuarioRequest){
        return new Usuario(
                usuarioRequest.id(),
                usuarioRequest.nombres(),
                usuarioRequest.apellidos(),
                usuarioRequest.fechaNacimiento(),
                usuarioRequest.direccion(),
                usuarioRequest.telefono(),
                usuarioRequest.correoElectronico(),
                usuarioRequest.salarioBase()
        );
    }

    public UsuarioData toData(Usuario usuario){
        return new UsuarioData(
                usuario.getId(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getFechaNacimiento(),
                usuario.getDireccion(),
                usuario.getTelefono(),
                usuario.getCorreoElectronico(),
                usuario.getSalarioBase()
        );
    }

}

