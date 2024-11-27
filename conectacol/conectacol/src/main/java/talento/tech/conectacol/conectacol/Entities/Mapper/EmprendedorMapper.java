package talento.tech.conectacol.conectacol.Entities.Mapper;



import talento.tech.conectacol.conectacol.Entities.DTO.EmprendedorDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Emprendedor;
import talento.tech.conectacol.conectacol.Entities.Domain.Usuario;

import java.util.List;

public interface EmprendedorMapper {
    Emprendedor toEmprendedor(EmprendedorDTO emprendedorDTO, Usuario usuario);

    EmprendedorDTO toEmprededorDTO(Emprendedor emprendedor);

    List<EmprendedorDTO> toEmprendedorDTOs(List<Emprendedor> emprendedores);
}
