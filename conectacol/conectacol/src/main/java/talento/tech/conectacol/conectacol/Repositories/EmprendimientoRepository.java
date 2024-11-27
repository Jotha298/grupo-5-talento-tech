package talento.tech.conectacol.conectacol.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import talento.tech.conectacol.conectacol.Entities.Domain.Emprendimiento;

public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Integer> {
}
