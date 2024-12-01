package talento.tech.conectacol.conectacol.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import talento.tech.conectacol.conectacol.Entities.DTO.RolDTO;
import talento.tech.conectacol.conectacol.Entities.Mapper.RolMapper;
import talento.tech.conectacol.conectacol.Entities.Domain.Rol;
import talento.tech.conectacol.conectacol.Repositories.RolRepository;
import talento.tech.conectacol.conectacol.Utilities.MyResponseUtility;

import java.util.Optional;

import static talento.tech.conectacol.conectacol.Utilities.ApplicationConstants.SERVER_ERROR;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private MyResponseUtility response;

    @Autowired
    private RolMapper rolMapper;


    public MyResponseUtility saveRol(RolDTO rolDTO){
        try {
            response = new MyResponseUtility();
            Rol rol = rolMapper.toUsuario(rolDTO);
            Rol rolguardado = rolRepository.save(rol);
            response.data = rolMapper.toRolDTO(rolguardado);
            response.status = HttpStatus.CREATED.value();
            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            response.error = true;
            return response;
        }

    }

    public MyResponseUtility findById(int idRol){

        try {
            response = new MyResponseUtility();
            Optional<Rol> optionalRol = rolRepository.findById(idRol);

            if (optionalRol.isEmpty()) {
                response.message = "Rol no encontrado con id: " + idRol;
                response.status = HttpStatus.NOT_FOUND.value();
                response.error = true;
                return response;
            }

            response.data = rolMapper.toRolDTO(optionalRol.get());
            response.status = HttpStatus.OK.value();
            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            response.error = true;
            return response;
        }
    }
}
