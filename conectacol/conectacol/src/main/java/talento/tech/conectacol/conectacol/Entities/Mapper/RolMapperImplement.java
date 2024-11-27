package talento.tech.conectacol.conectacol.Entities.Mapper;

import org.springframework.stereotype.Component;
import talento.tech.conectacol.conectacol.Entities.DTO.RolDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Rol;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RolMapperImplement implements RolMapper{
    @Override
    public Rol toUsuario(RolDTO rolDTO) {
        if (rolDTO == null) {
            return null;
        }

        Rol rol = new Rol();
        rol.setNombre(rolDTO.getNombre());
        return rol;
    }

    @Override
    public RolDTO toRolDTO(Rol rol) {
        if (rol == null) {
            return null;
        }

        RolDTO rolDTO = new RolDTO();
        rolDTO.setIdRol(rol.getIdRol());
        rolDTO.setNombre(rol.getNombre());
        return rolDTO;
    }

    @Override
    public List<RolDTO> toRolDTOs(List<Rol> rols) {
        if (rols == null || rols.isEmpty()) {
            return List.of(); // Retorna una lista vacía si no hay roles
        }

        return rols.stream()
                .map(this::toRolDTO) // Convierte cada Rol a RolDTO
                .collect(Collectors.toList());
    }
}
