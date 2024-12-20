package talento.tech.conectacol.conectacol.Entities.Domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSector;

    @Column(nullable = false, length = 50)
    private String nombre;


}
