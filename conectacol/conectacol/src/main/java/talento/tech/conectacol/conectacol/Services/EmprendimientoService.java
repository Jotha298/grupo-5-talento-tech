package talento.tech.conectacol.conectacol.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import talento.tech.conectacol.conectacol.Entities.DTO.EmprendimientoDTO;
import talento.tech.conectacol.conectacol.Entities.DTO.UsuarioDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.*;
import talento.tech.conectacol.conectacol.Entities.Mapper.EmprendimientoMapper;
import talento.tech.conectacol.conectacol.Repositories.EmprendedorRepository;
import talento.tech.conectacol.conectacol.Repositories.EmprendimientoRepository;
import talento.tech.conectacol.conectacol.Repositories.SectorRepository;
import talento.tech.conectacol.conectacol.Utilities.MyResponseUtility;

import java.util.Optional;

import static talento.tech.conectacol.conectacol.Utilities.ApplicationConstants.SERVER_ERROR;

@Service
public class EmprendimientoService {

    @Autowired
    private EmprendedorRepository emprendedorRepository;

    @Autowired
    private  EmprendimientoRepository emprendimientoRepository;

    @Autowired
    private  SectorRepository sectorRepository;

    @Autowired
    private  EmprendimientoMapper emprendimientoMapper;

    @Autowired
    private MyResponseUtility response;

    public MyResponseUtility createEntrepreneurship(EmprendimientoDTO emprendimientoDTO){

        try {

            response = new MyResponseUtility();
            Optional<Emprendedor> optionalEmprendedor = emprendedorRepository.findById(emprendimientoDTO.getIdEmprendedor());

            if (optionalEmprendedor.isEmpty()) {
                response.message = "Emprendedor no encontrado con id: " + emprendimientoDTO.getIdEmprendedor();
                response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
                response.error = true;
                return response;
            }

            Optional<Sector> optionalSector = sectorRepository.findById(emprendimientoDTO.getIdSector());

            if (optionalSector.isEmpty()) {
                response.message = "Sector no encontrado con id: " + emprendimientoDTO.getIdEmprendedor();
                response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
                response.error = true;
                return response;
            }


            // Convertir el DTO en una entidad
            Emprendimiento emprendimiento = emprendimientoMapper.toEmpreprendimiento(emprendimientoDTO, optionalEmprendedor.get(), optionalSector.get());

            // Guardar el usuario en la base de datos
            Emprendimiento emprendimientoGuardado = emprendimientoRepository.save(emprendimiento);

            // Convertir la entidad guardada de vuelta a DTO
            response.data =  emprendimientoMapper.toEmprendimientoDTO(emprendimientoGuardado);

            response.status = HttpStatus.CREATED.value();

            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            response.error = true;
            return response;
        }
    }

    public MyResponseUtility findById(int idEmprendimiento){

        try {
            response = new MyResponseUtility();
            Optional<Emprendimiento> optionalEmprendimiento = emprendimientoRepository.findById(idEmprendimiento);

            if (optionalEmprendimiento.isEmpty()) {
                response.message = "Emprendimiento no encontrado con id: " + idEmprendimiento;
                response.status = HttpStatus.NOT_FOUND.value();
                response.error = true;
                return response;
            }

            response.data = emprendimientoMapper.toEmprendimientoDTO(optionalEmprendimiento.get());
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
