package talento.tech.conectacol.conectacol.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import talento.tech.conectacol.conectacol.Entities.Rol;
import talento.tech.conectacol.conectacol.Repositories.RolRepository;
import talento.tech.conectacol.conectacol.utilities.MyResponseUtility;

import java.util.Optional;

import static talento.tech.conectacol.conectacol.utilities.ApplicationConstants.SERVER_ERROR;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    private MyResponseUtility response;

    public MyResponseUtility saveRol(Rol rol){
        try {
            response = new MyResponseUtility();
            response.data = rolRepository.save(rol);
            response.status = HttpStatus.CREATED.value();
            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }

    }

    public MyResponseUtility findById(int id){

        try {
            response = new MyResponseUtility();
            response.data = rolRepository.findById(id);
            response.status = HttpStatus.CREATED.value();
            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }
    }
}
