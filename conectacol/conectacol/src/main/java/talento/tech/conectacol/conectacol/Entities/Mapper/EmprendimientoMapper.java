package talento.tech.conectacol.conectacol.Entities.Mapper;



import talento.tech.conectacol.conectacol.Entities.DTO.EmprendimientoDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Emprendedor;
import talento.tech.conectacol.conectacol.Entities.Domain.Emprendimiento;
import talento.tech.conectacol.conectacol.Entities.Domain.Sector;

import java.util.List;

public interface EmprendimientoMapper {

    Emprendimiento toEmpreprendimiento(EmprendimientoDTO emprendimientoDTO, Emprendedor emprendedor, Sector sector);

    EmprendimientoDTO toEmprendimientoDTO(Emprendimiento emprendimiento);

    List<EmprendimientoDTO> toEmprendimientoDTOs(List<Emprendimiento> emprendimientos);
}
