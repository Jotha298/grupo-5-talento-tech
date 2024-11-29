package talento.tech.conectacol.conectacol.Entities.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class ContactoDTO {

    private Integer idContacto;
    private Date fechaContacto;
    private Integer idEmprendimiento;
    private Integer idInversionista;

}
