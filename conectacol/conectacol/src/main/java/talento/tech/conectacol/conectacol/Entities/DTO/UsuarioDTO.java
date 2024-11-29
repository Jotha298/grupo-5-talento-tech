package talento.tech.conectacol.conectacol.Entities.DTO;

import lombok.Data;
import talento.tech.conectacol.conectacol.Entities.Enums.TipoDocumento;

import java.math.BigInteger;

@Data
public class UsuarioDTO {
    private Integer idUsuario;
    private TipoDocumento tipoDocumento;
    private String documento;
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private String contrasenia;
    private Integer edad;
    private BigInteger celular;
    private Integer idRol;
}
