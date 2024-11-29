package talento.tech.conectacol.conectacol.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import talento.tech.conectacol.conectacol.Entities.Domain.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto, Integer> {
}
