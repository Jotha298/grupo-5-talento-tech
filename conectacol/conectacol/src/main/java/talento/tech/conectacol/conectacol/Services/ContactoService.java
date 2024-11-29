package talento.tech.conectacol.conectacol.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import talento.tech.conectacol.conectacol.Entities.DTO.ContactoDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.*;
import talento.tech.conectacol.conectacol.Entities.Mapper.ContactoMapper;
import talento.tech.conectacol.conectacol.Repositories.ContactoRepository;
import talento.tech.conectacol.conectacol.Repositories.EmprendimientoRepository;
import talento.tech.conectacol.conectacol.Repositories.InversionistaRepository;
import talento.tech.conectacol.conectacol.Utilities.MyResponseUtility;

import java.util.Optional;

import static talento.tech.conectacol.conectacol.Utilities.ApplicationConstants.SERVER_ERROR;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    @Autowired
    private ContactoMapper contactoMapper;

    @Autowired
    private EmprendimientoRepository emprendimientoRepository;

    @Autowired
    private InversionistaRepository inversionistaRepository;

    @Autowired
    private MyResponseUtility response;


    public MyResponseUtility createContact(ContactoDTO contactoDTO){
        try {

            response = new MyResponseUtility();
            Optional<Emprendimiento> optionalEmprendimiento = emprendimientoRepository.findById(contactoDTO.getIdEmprendimiento());

            if (optionalEmprendimiento.isEmpty()) {
                response.message = "Emprendimiento no encontrado con id: " + contactoDTO.getIdEmprendimiento();
                response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
                response.error = true;
                return response;
            }

            Optional<Inversionista> optionalInversionista = inversionistaRepository.findById(contactoDTO.getIdInversionista());

            if (optionalInversionista.isEmpty()) {
                response.message = "Inversionista no encontrado con id: " + contactoDTO.getIdInversionista();
                response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
                response.error = true;
                return response;
            }


            // Mapear el DTO a entidad
            Contacto contacto = contactoMapper.toContacto(contactoDTO, optionalEmprendimiento.get(), optionalInversionista.get());

            // Guardar la entidad en el repositorio
            Contacto contactoGuardado = contactoRepository.save(contacto);

            // Convertir la entidad guardada de vuelta a DTO
            response.data =  contactoMapper.toContactoDTO(contactoGuardado);

            response.status = HttpStatus.CREATED.value();

            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            response.error = true;
            return response;
        }

    }

    public MyResponseUtility findById(int idContacto){

        try {
            response = new MyResponseUtility();

            Optional<Contacto> optionalContacto = contactoRepository.findById(idContacto);

            if (optionalContacto.isEmpty()) {
                response.message = "Contacto no encontrado con id: " + idContacto;
                response.status = HttpStatus.NOT_FOUND.value();
                response.error = true;
                return response;
            }

            response.data = contactoMapper.toContactoDTO(optionalContacto.get());
            response.status = HttpStatus.CREATED.value();
            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            response.error = true;
            return response;
        }
    }

}
