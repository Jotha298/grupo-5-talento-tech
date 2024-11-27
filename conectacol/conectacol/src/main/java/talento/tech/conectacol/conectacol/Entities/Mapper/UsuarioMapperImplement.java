package talento.tech.conectacol.conectacol.Entities.Mapper;

import org.springframework.stereotype.Component;
import talento.tech.conectacol.conectacol.Entities.DTO.UsuarioDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Rol;
import talento.tech.conectacol.conectacol.Entities.Domain.Usuario;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapperImplement implements UsuarioMapper{
    @Override
    public Usuario toUsuario(UsuarioDTO usuarioDTO, Rol rol) {

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(usuarioDTO.getIdUsuario());
        usuario.setTipoDocumento(usuarioDTO.getTipoDocumento());
        usuario.setDocumento(usuarioDTO.getDocumento());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellidos(usuarioDTO.getApellidos());
        usuario.setCorreoElectronico(usuarioDTO.getCorreoElectronico());
        usuario.setCelular(usuarioDTO.getCelular());
        usuario.setRol(rol);

        return usuario;

    }

    @Override
    public UsuarioDTO toUsuarioDTO(Usuario usuario) {

        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setTipoDocumento(usuario.getTipoDocumento());
        dto.setDocumento(usuario.getDocumento());
        dto.setNombre(usuario.getNombre());
        dto.setApellidos(usuario.getApellidos());
        dto.setCorreoElectronico(usuario.getCorreoElectronico());
        dto.setCelular(usuario.getCelular());
        dto.setIdRol(usuario.getRol().getIdRol());
        return dto;

    }

    @Override
    public List<UsuarioDTO> toUsuarioDTOs(List<Usuario> usuarios) {
        if (usuarios == null || usuarios.isEmpty()) {
            return Collections.emptyList(); // Retorna una lista vacía si la entrada es nula o vacía
        }

        return usuarios.stream()
                .map(this::toUsuarioDTO) // Convierte cada Usuario a UsuarioDTO usando el metodo toUsuarioDTO
                .collect(Collectors.toList());
    }

}
