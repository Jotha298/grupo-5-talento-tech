package talento.tech.conectacol.conectacol.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import talento.tech.conectacol.conectacol.Entities.DTO.EmprendimientoDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.*;
import talento.tech.conectacol.conectacol.Entities.Mapper.EmprendimientoMapper;
import talento.tech.conectacol.conectacol.Repositories.EmprendedorRepository;
import talento.tech.conectacol.conectacol.Repositories.EmprendimientoRepository;
import talento.tech.conectacol.conectacol.Repositories.SectorRepository;
import talento.tech.conectacol.conectacol.Utilities.MyResponseUtility;

import java.util.List;
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

            // Guardar el emprendimiento en la base de datos
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
            response.status = HttpStatus.OK.value();
            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            response.error = true;
            return response;
        }
    }

    public MyResponseUtility findEntrepreneurshipByIdEnterpreneur(int idEmprendedor){

        try {

            List<Emprendimiento> emprendimientos = emprendimientoRepository.findAllByEmprendedorId(idEmprendedor);
            response.data = emprendimientoMapper.toEmprendimientoDTOs(emprendimientos);
            response.status = HttpStatus.OK.value();
            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            response.error = true;
            return response;
        }

    }

    public MyResponseUtility getAllEntrepreneurships(){

        try {

            List<Emprendimiento> emprendimientos = emprendimientoRepository.findAll();
            response.data = emprendimientoMapper.toEmprendimientoDTOs(emprendimientos);
            response.status = HttpStatus.OK.value();
            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            response.error = true;
            return response;
        }

    }

    public MyResponseUtility updateEntrepreneurships(int idEmprendimiento, EmprendimientoDTO emprendimientoDTO){
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

            Optional<Emprendimiento> foundEntrepreneurship = emprendimientoRepository.findById(idEmprendimiento);
            if (foundEntrepreneurship.isPresent()) {
                Emprendimiento existingEmprendimiento = foundEntrepreneurship.get();

                existingEmprendimiento.setTitulo(emprendimientoDTO.getTitulo());
                existingEmprendimiento.setDescripcion(emprendimientoDTO.getDescripcion());
                existingEmprendimiento.setUbicacion(emprendimientoDTO.getUbicacion());
                existingEmprendimiento.setRendimiento(emprendimientoDTO.getRendimiento());
                existingEmprendimiento.setMontoRequerido(emprendimientoDTO.getMontoRequerido());
                existingEmprendimiento.setEstado(emprendimientoDTO.getEstado());
                existingEmprendimiento.setUrlImagen(emprendimientoDTO.getUrlImagen());
                existingEmprendimiento.setEmprendedor(optionalEmprendedor.get());
                existingEmprendimiento.setSector(optionalSector.get());

                // Guardar el emprendimiento en la base de datos
                Emprendimiento emprendimientoGuardado = emprendimientoRepository.save(existingEmprendimiento);

                // Convertir la entidad guardada de vuelta a DTO
                response.data =  emprendimientoMapper.toEmprendimientoDTO(emprendimientoGuardado);

                response.status = HttpStatus.CREATED.value();

                return response;
            } else {
                response.message = "Emprendimiento no encontrado con id: " + idEmprendimiento;
                response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
                response.error = true;
                return response;
            }


        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            response.error = true;
            return response;
        }

    }

    public MyResponseUtility deleteEntrepreneurships(int idEmprendimiento){
        try{

            response = new MyResponseUtility();
            Optional<Emprendimiento> optionalEmprendimiento = emprendimientoRepository.findById(idEmprendimiento);

            if (optionalEmprendimiento.isEmpty()) {
                response.message = "Emprendimiento no encontrado con id: " + idEmprendimiento;
                response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
                response.error = true;
                return response;
            }

            emprendimientoRepository.deleteById(idEmprendimiento);
            response.message = "El emprendimiento "+ optionalEmprendimiento.get().getTitulo() + " fue eliminado con éxito";
            response.status = HttpStatus.OK.value();
            return response;

        }catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            response.error = true;
            return response;
        }
    }
}
