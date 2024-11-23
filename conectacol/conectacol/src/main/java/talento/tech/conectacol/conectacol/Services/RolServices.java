package talento.tech.conectacol.conectacol.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import talento.tech.conectacol.conectacol.Entities.Rol;
import talento.tech.conectacol.conectacol.Repositories.RolRepository;

import java.util.Optional;

@Service
public class RolServices {

    @Autowired
    private RolRepository rolRepository;

    public Rol saveRol(Rol rol){
        return rolRepository.save(rol);
    }

    public Optional<Rol> findById(int id){
        return rolRepository.findById(id);
    }
}
