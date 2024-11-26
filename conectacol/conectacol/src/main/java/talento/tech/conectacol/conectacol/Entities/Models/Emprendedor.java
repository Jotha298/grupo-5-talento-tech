package talento.tech.conectacol.conectacol.Entities.Models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Emprendedor {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmprendedor;

    @Column(nullable = false)
    private Double experiencia;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "idUsuario", nullable = false, unique = true)
    private Usuario usuario;


}
