package talento.tech.conectacol.conectacol.Entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSector;

    @Column(nullable = false, length = 50)
    private String nombre;

}