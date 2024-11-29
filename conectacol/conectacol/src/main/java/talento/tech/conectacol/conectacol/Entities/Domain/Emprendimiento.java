package talento.tech.conectacol.conectacol.Entities.Domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Entity
public class Emprendimiento {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmprendimiento;

    @Column(nullable = false, length = 50)
    private String titulo;

    @Column(nullable = false, length = 2000)
    private String descripcion;

    @Column(nullable = false, length = 150)
    private String ubicacion;

    @Column(nullable = false)
    private Double rendimiento;

    @Column(nullable = false)
    private Double montoRequerido;

    @Column(nullable = false)
    private Boolean estado;

    @Column(nullable = false, length = 3000)
    private String urlImagen;

    @Column(nullable = false)
    private Date fechaInversion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emprendedor_id", referencedColumnName = "idEmprendedor", nullable = false)
    private Emprendedor emprendedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id", referencedColumnName = "idSector", nullable = false)
    private Sector sector;

    @OneToMany(mappedBy = "emprendimiento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contacto> contactos;


}
