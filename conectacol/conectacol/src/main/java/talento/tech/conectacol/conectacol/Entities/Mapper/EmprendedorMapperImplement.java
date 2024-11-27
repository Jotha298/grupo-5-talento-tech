package talento.tech.conectacol.conectacol.Entities.Mapper;

import org.springframework.stereotype.Component;
import talento.tech.conectacol.conectacol.Entities.DTO.EmprendedorDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Emprendedor;
import talento.tech.conectacol.conectacol.Entities.Domain.Usuario;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmprendedorMapperImplement implements EmprendedorMapper {
    @Override
    public Emprendedor toEmprendedor(EmprendedorDTO emprendedorDTO, Usuario usuario) {
        if (emprendedorDTO == null || usuario == null) {
            return null;
        }

        Emprendedor emprendedor = new Emprendedor();
        emprendedor.setIdEmprendedor(emprendedorDTO.getIdEmprendedor());
        emprendedor.setExperiencia(emprendedorDTO.getExperiencia());
        emprendedor.setUsuario(usuario);
        return emprendedor;
    }

    @Override
    public EmprendedorDTO toEmprededorDTO(Emprendedor emprendedor) {
        if (emprendedor == null) {
            return null;
        }

        EmprendedorDTO emprendedorDTO = new EmprendedorDTO();
        emprendedorDTO.setIdEmprendedor(emprendedor.getIdEmprendedor());
        emprendedorDTO.setExperiencia(emprendedor.getExperiencia());

        Usuario usuario = emprendedor.getUsuario();
        if (usuario != null) {
            emprendedorDTO.setIdUsuario(usuario.getIdUsuario());
        }

        return emprendedorDTO;
    }

    @Override
    public List<EmprendedorDTO> toEmprendedorDTOs(List<Emprendedor> emprendedores) {
        if (emprendedores == null || emprendedores.isEmpty()) {
            return List.of();
        }

        return emprendedores.stream()
                .map(this::toEmprededorDTO) // Mapear cada Emprendedor a EmprendedorDTO
                .collect(Collectors.toList());
    }
}
