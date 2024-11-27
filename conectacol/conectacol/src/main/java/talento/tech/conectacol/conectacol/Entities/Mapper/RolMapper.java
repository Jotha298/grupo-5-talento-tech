package talento.tech.conectacol.conectacol.Entities.Mapper;

import talento.tech.conectacol.conectacol.Entities.DTO.RolDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Rol;


import java.util.List;

public interface RolMapper {

    Rol toUsuario(RolDTO rolDTO);

    RolDTO toRolDTO(Rol rol);

    List<RolDTO> toRolDTOs(List<Rol> rols);
}
