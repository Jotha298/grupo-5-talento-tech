package talento.tech.conectacol.conectacol.Entities.DTO;

import lombok.Data;
import talento.tech.conectacol.conectacol.Entities.Enums.TipoDocumento;

import java.math.BigInteger;

@Data
public class UsuarioDTO {
    private TipoDocumento tipoDocumento;
    private String documento;
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private BigInteger celular;
    private int idRol;
}
