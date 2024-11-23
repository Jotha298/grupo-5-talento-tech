package talento.tech.conectacol.conectacol.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import talento.tech.conectacol.conectacol.Entities.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}
