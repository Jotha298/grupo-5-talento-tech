package talento.tech.conectacol.conectacol.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import talento.tech.conectacol.conectacol.Entities.DTO.UsuarioDTO;
import talento.tech.conectacol.conectacol.Entities.Mapper.UsuarioMapper;
import talento.tech.conectacol.conectacol.Entities.Rol;
import talento.tech.conectacol.conectacol.Entities.Usuario;
import talento.tech.conectacol.conectacol.Repositories.RolRepository;
import talento.tech.conectacol.conectacol.Repositories.UsuarioRepository;
import talento.tech.conectacol.conectacol.utilities.MyResponseUtility;

import java.util.Optional;

import static talento.tech.conectacol.conectacol.utilities.ApplicationConstants.SERVER_ERROR;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MyResponseUtility response;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private RolRepository rolRepository;


    public MyResponseUtility createUsers(UsuarioDTO usuarioDTO){

        try {
            Optional<Rol> optionalRol = rolRepository.findById(usuarioDTO.getIdRol());

            if (optionalRol.isEmpty()) {
                response.message = "Rol no encontrado con id: " + usuarioDTO.getIdRol();
                response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
                return response;
            }

            response = new MyResponseUtility();
            // Convertir el DTO en una entidad
            Usuario usuario = usuarioMapper.toUsuario(usuarioDTO, optionalRol.get());

            // Guardar el usuario en la base de datos
            Usuario usuarioGuardado = usuarioRepository.save(usuario);

            // Convertir la entidad guardada de vuelta a DTO
            response.data =  usuarioMapper.toUsuarioDTO(usuarioGuardado);

            response.status = HttpStatus.CREATED.value();

            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }
    }

    public MyResponseUtility findById(int idUsuario){

        try {
            response = new MyResponseUtility();
            response.data = usuarioRepository.findById(idUsuario);
            response.status = HttpStatus.CREATED.value();
            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }
    }
}
