package talento.tech.conectacol.conectacol.Entities.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class EmprendimientoDTO {
    private Integer idEmprendimiento;
    private String titulo;
    private String descripcion;
    private String ubicacion;
    private Double rendimiento;
    private Double montoRequerido;
    private Boolean estado;
    private String urlImagen;
    private Integer idEmprendedor;
    private Integer idSector;

}
