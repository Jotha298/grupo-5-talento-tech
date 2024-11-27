package talento.tech.conectacol.conectacol.Entities.Domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Emprendedor {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmprendedor;

    @Column(nullable = false)
    private Double experiencia;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "idUsuario", nullable = false, unique = true)
    private Usuario usuario;

    @OneToMany(mappedBy = "emprendedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Emprendimiento> emprendimientos;


}
