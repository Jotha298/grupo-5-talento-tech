package talento.tech.conectacol.conectacol.Entities.Mapper;

import org.springframework.stereotype.Component;
import talento.tech.conectacol.conectacol.Entities.DTO.EmprendimientoDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Emprendedor;
import talento.tech.conectacol.conectacol.Entities.Domain.Emprendimiento;
import talento.tech.conectacol.conectacol.Entities.Domain.Sector;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmprendimientoMapperImplement implements EmprendimientoMapper{
    @Override
    public Emprendimiento toEmpreprendimiento(EmprendimientoDTO emprendimientoDTO, Emprendedor emprendedor, Sector sector) {
        if (emprendimientoDTO == null || emprendedor == null || sector == null) {
            return null;
        }

        Emprendimiento emprendimiento = new Emprendimiento();
        emprendimiento.setIdEmprendimiento(emprendimientoDTO.getIdEmprendimiento());
        emprendimiento.setTitulo(emprendimientoDTO.getTitulo());
        emprendimiento.setDescripcion(emprendimientoDTO.getDescripcion());
        emprendimiento.setUbicacion(emprendimientoDTO.getUbicacion());
        emprendimiento.setRendimiento(emprendimientoDTO.getRendimiento());
        emprendimiento.setMontoRequerido(emprendimientoDTO.getMontoRequerido());
        emprendimiento.setEstado(emprendimientoDTO.getEstado());
        emprendimiento.setUrlImagen(emprendimientoDTO.getUrlImagen());
        emprendimiento.setEmprendedor(emprendedor); // Relación con Emprendedor
        emprendimiento.setSector(sector); // Relación con Sector
        return emprendimiento;
    }

    @Override
    public EmprendimientoDTO toEmprendimientoDTO(Emprendimiento emprendimiento) {
        if (emprendimiento == null) {
            return null;
        }

        EmprendimientoDTO emprendimientoDTO = new EmprendimientoDTO();
        emprendimientoDTO.setIdEmprendimiento(emprendimiento.getIdEmprendimiento());
        emprendimientoDTO.setTitulo(emprendimiento.getTitulo());
        emprendimientoDTO.setDescripcion(emprendimiento.getDescripcion());
        emprendimientoDTO.setUbicacion(emprendimiento.getUbicacion());
        emprendimientoDTO.setRendimiento(emprendimiento.getRendimiento());
        emprendimientoDTO.setMontoRequerido(emprendimiento.getMontoRequerido());
        emprendimientoDTO.setEstado(emprendimiento.getEstado());
        emprendimientoDTO.setUrlImagen(emprendimiento.getUrlImagen());

        // Mapear datos del Emprendedor asociado
        Emprendedor emprendedor = emprendimiento.getEmprendedor();
        if (emprendedor != null) {
            emprendimientoDTO.setIdEmprendedor(emprendedor.getIdEmprendedor());
        }

        // Mapear datos del Sector asociado
        Sector sector = emprendimiento.getSector();
        if (sector != null) {
            emprendimientoDTO.setIdSector(sector.getIdSector());
        }

        return emprendimientoDTO;
    }

    @Override
    public List<EmprendimientoDTO> toEmprendimientoDTOs(List<Emprendimiento> emprendimientos) {
        if (emprendimientos == null || emprendimientos.isEmpty()) {
            return List.of();
        }

        return emprendimientos.stream()
                .map(this::toEmprendimientoDTO)
                .collect(Collectors.toList());
    }
}

