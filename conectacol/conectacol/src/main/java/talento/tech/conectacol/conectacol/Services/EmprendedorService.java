package talento.tech.conectacol.conectacol.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import talento.tech.conectacol.conectacol.Entities.DTO.EmprendedorDTO;
import talento.tech.conectacol.conectacol.Entities.Mapper.EmprendedorMapper;
import talento.tech.conectacol.conectacol.Entities.Models.Emprendedor;
import talento.tech.conectacol.conectacol.Entities.Models.Rol;
import talento.tech.conectacol.conectacol.Entities.Models.Usuario;
import talento.tech.conectacol.conectacol.Repositories.EmprendedorRepository;
import talento.tech.conectacol.conectacol.Repositories.UsuarioRepository;
import talento.tech.conectacol.conectacol.utilities.MyResponseUtility;

import java.util.Optional;

import static talento.tech.conectacol.conectacol.utilities.ApplicationConstants.SERVER_ERROR;

@Service
public class EmprendedorService {

    @Autowired
    private EmprendedorRepository emprendedorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MyResponseUtility response;

    @Autowired
    private EmprendedorMapper emprendedorMapper;

    public MyResponseUtility createEnterpreneur(EmprendedorDTO emprendedorDTO){

        try {

            Optional<Usuario> optionalUser = usuarioRepository.findById(emprendedorDTO.getIdUsuario());

            if (optionalUser.isEmpty()) {
                response.message = "Usuario no encontrado con id: " + emprendedorDTO.getIdUsuario();
                response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
                response.error = true;
                return response;
            }
            response = new MyResponseUtility();
            // Convertir el DTO en una entidad
            Emprendedor emprendedor = emprendedorMapper.toEmprendedor(emprendedorDTO, optionalUser.get());

            // Guardar el usuario en la base de datos
            Emprendedor emprendedorGuardado = emprendedorRepository.save(emprendedor);

            // Convertir la entidad guardada de vuelta a DTO
            response.data =  emprendedorMapper.toEmprededorDTO(emprendedorGuardado);

            response.status = HttpStatus.CREATED.value();

            return response;

        }  catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            response.error = true;
            return response;
        }
    }
    public MyResponseUtility findById(int idEmprendedor){

        try {
            response = new MyResponseUtility();
            Optional<Emprendedor> optionalEmprendedor = emprendedorRepository.findById(idEmprendedor);

            if (optionalEmprendedor.isEmpty()) {
                response.message = "Emprendedor no encontrado con id: " + idEmprendedor;
                response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
                response.error = true;
                return response;
            }

            response.data = emprendedorMapper.toEmprededorDTO(optionalEmprendedor.get());
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
