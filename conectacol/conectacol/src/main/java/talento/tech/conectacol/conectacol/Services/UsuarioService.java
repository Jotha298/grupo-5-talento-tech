package talento.tech.conectacol.conectacol.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import talento.tech.conectacol.conectacol.Entities.Usuario;
import talento.tech.conectacol.conectacol.Repositories.UsuarioRepository;
import talento.tech.conectacol.conectacol.utilities.MyResponseUtility;

import static talento.tech.conectacol.conectacol.utilities.ApplicationConstants.SERVER_ERROR;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private MyResponseUtility response;

    public MyResponseUtility createUsers(Usuario usuario){

        try {
            response = new MyResponseUtility();
            response.data = usuarioRepository.save(usuario);
            response.status = HttpStatus.CREATED.value();
            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }
    }
}
