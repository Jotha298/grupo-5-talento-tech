package talento.tech.conectacol.conectacol.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import talento.tech.conectacol.conectacol.Entities.DTO.UsuarioDTO;
import talento.tech.conectacol.conectacol.Entities.Mapper.UsuarioMapper;
import talento.tech.conectacol.conectacol.Entities.Domain.Rol;
import talento.tech.conectacol.conectacol.Entities.Domain.Usuario;
import talento.tech.conectacol.conectacol.Repositories.RolRepository;
import talento.tech.conectacol.conectacol.Repositories.UsuarioRepository;
import talento.tech.conectacol.conectacol.Utilities.MyResponseUtility;

import java.util.Optional;

import static talento.tech.conectacol.conectacol.Utilities.ApplicationConstants.SERVER_ERROR;

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
                response.error = true;
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
            response.error = true;
            return response;
        }
    }

    public MyResponseUtility findById(int idUsuario){

        try {
            response = new MyResponseUtility();
            Optional<Usuario> optionalUsuario =usuarioRepository.findById(idUsuario);

            if (optionalUsuario.isEmpty()) {
                response.message = "Usuario no encontrado con id: " + idUsuario;
                response.status = HttpStatus.NOT_FOUND.value();
                response.error = true;
                return response;
            }

            response.data = usuarioMapper.toUsuarioDTO(optionalUsuario.get());
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
