package talento.tech.conectacol.conectacol.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import talento.tech.conectacol.conectacol.Entities.Domain.Emprendedor;

public interface EmprendedorRepository extends JpaRepository<Emprendedor, Integer> {
}
