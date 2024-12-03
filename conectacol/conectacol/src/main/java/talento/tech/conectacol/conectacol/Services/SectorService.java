package talento.tech.conectacol.conectacol.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import talento.tech.conectacol.conectacol.Entities.DTO.SectorDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Rol;
import talento.tech.conectacol.conectacol.Entities.Domain.Sector;
import talento.tech.conectacol.conectacol.Entities.Mapper.SectorMapper;
import talento.tech.conectacol.conectacol.Repositories.SectorRepository;
import talento.tech.conectacol.conectacol.Utilities.MyResponseUtility;

import java.util.List;
import java.util.Optional;

import static talento.tech.conectacol.conectacol.Utilities.ApplicationConstants.SERVER_ERROR;

@Service
public class SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private MyResponseUtility response;

    @Autowired
    private SectorMapper sectorMapper;

    public MyResponseUtility createSector(SectorDTO sectorDTO) {

        try {
            response = new MyResponseUtility();
            Sector sector = sectorMapper.toSector(sectorDTO);
            Sector sectorguardado = sectorRepository.save(sector);
            response.data = sectorMapper.toSectorDTO(sectorguardado);
            response.status = HttpStatus.CREATED.value();
            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            response.error = true;
            return response;
        }
    }

    public MyResponseUtility findById(int idSector) {
        try {
            response = new MyResponseUtility();
            Optional<Sector> optionalSector = sectorRepository.findById(idSector);

            if (optionalSector.isEmpty()) {
                response.message = "Sector no encontrado con id: " + idSector;
                response.status = HttpStatus.NOT_FOUND.value();
                response.error = true;
                return response;
            }

            response.data = sectorMapper.toSectorDTO(optionalSector.get());
            response.status = HttpStatus.OK.value();
            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            response.error = true;
            return response;
        }

    }
    public MyResponseUtility findAll(){

        try {
            response = new MyResponseUtility();
            List<Sector> optionalSector = sectorRepository.findAll();

            response.data = sectorMapper.toSectorDTOs(optionalSector);
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
