package talento.tech.conectacol.conectacol.Entities.Mapper;

import talento.tech.conectacol.conectacol.Entities.DTO.UsuarioDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Rol;
import talento.tech.conectacol.conectacol.Entities.Domain.Usuario;

import java.util.List;

public interface UsuarioMapper {


    Usuario toUsuario(UsuarioDTO usuarioDTO, Rol rol);

    UsuarioDTO toUsuarioDTO(Usuario usuario);

    List<UsuarioDTO> toUsuarioDTOs(List<Usuario> usuarios);


}
