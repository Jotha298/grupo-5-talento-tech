package talento.tech.conectacol.conectacol.Entities.Domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Contacto {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContacto;

    @Column(nullable = false)
    private Date fechaContacto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emprendimiento_id", referencedColumnName = "idEmprendimiento", nullable = false)
    private Emprendimiento emprendimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inversionista_id", referencedColumnName = "idInversionista", nullable = false)
    private Inversionista inversionista;
}
