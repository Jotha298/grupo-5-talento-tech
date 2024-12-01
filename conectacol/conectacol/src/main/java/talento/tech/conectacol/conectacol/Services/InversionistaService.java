package talento.tech.conectacol.conectacol.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import talento.tech.conectacol.conectacol.Entities.DTO.InversionistaDTO;
import talento.tech.conectacol.conectacol.Entities.Mapper.InversionistaMapper;
import talento.tech.conectacol.conectacol.Entities.Domain.Inversionista;
import talento.tech.conectacol.conectacol.Entities.Domain.Usuario;
import talento.tech.conectacol.conectacol.Repositories.InversionistaRepository;
import talento.tech.conectacol.conectacol.Repositories.UsuarioRepository;
import talento.tech.conectacol.conectacol.Utilities.MyResponseUtility;

import java.util.Optional;

import static talento.tech.conectacol.conectacol.Utilities.ApplicationConstants.SERVER_ERROR;

@Service
public class InversionistaService {

    @Autowired
    private InversionistaRepository inversionistaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MyResponseUtility response;

    @Autowired
    private InversionistaMapper inversionistaMapper;

    public MyResponseUtility createInvestor(InversionistaDTO inversionistaDTO){

        try {

            Optional<Usuario> optionalUser = usuarioRepository.findById(inversionistaDTO.getIdUsuario());

            if (optionalUser.isEmpty()) {
                response.message = "Usuario no encontrado con id: " + inversionistaDTO.getIdUsuario();
                response.status = HttpStatus.NOT_FOUND.value();
                response.error = true;
                return response;
            }
            response = new MyResponseUtility();
            // Convertir el DTO en una entidad
            Inversionista inversionista = inversionistaMapper.toInversionista(inversionistaDTO, optionalUser.get());

            // Guardar el usuario en la base de datos
            Inversionista inversionistaGuardado = inversionistaRepository.save(inversionista);

            // Convertir la entidad guardada de vuelta a DTO
            response.data =  inversionistaMapper.toInversionistaDTO(inversionistaGuardado);

            response.status = HttpStatus.CREATED.value();

            return response;

        }  catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            response.error = true;
            return response;
        }
    }
    public MyResponseUtility findById(int idInversionista){

        try {
            response = new MyResponseUtility();
            Optional<Inversionista> optionalInversionista = inversionistaRepository.findById(idInversionista);

            if (optionalInversionista.isEmpty()) {
                response.message = "Inversionista no encontrado con id: " + idInversionista;
                response.status = HttpStatus.NOT_FOUND.value();
                response.error = true;
                return response;
            }

            response.data = inversionistaMapper.toInversionistaDTO(optionalInversionista.get());
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
