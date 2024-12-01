package talento.tech.conectacol.conectacol.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import talento.tech.conectacol.conectacol.Entities.Domain.Emprendimiento;

import java.util.List;

public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Integer> {

    @Query("SELECT e FROM Emprendimiento e WHERE e.emprendedor.id = :emprendedorId")
    List<Emprendimiento> findAllByEmprendedorId(@Param("emprendedorId") Integer emprendedorId);
}
