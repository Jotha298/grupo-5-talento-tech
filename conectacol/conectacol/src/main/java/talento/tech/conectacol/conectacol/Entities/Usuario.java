package talento.tech.conectacol.conectacol.Entities;

import jakarta.persistence.*;
import lombok.Data;
import talento.tech.conectacol.conectacol.Entities.Enums.TipoDocumento;

import java.math.BigInteger;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @Column(nullable = false, length=15)
    private String documento;

    @Column(nullable = false, length=25)
    private String nombre;

    @Column(nullable = false, length=25)
    private String apellidos;

    @Column(nullable = false, length=50)
    private String correoElectronico;

    @Column(nullable = false)
    private BigInteger celular;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Rol.class)
    @JoinColumn(name = "idRol", referencedColumnName = "idRol", insertable = false,updatable = false)
    private Rol rol;

}
