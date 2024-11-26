package talento.tech.conectacol.conectacol.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import talento.tech.conectacol.conectacol.Entities.Domain.Sector;
import talento.tech.conectacol.conectacol.Repositories.SectorRepository;
import talento.tech.conectacol.conectacol.Utilities.MyResponseUtility;

import static talento.tech.conectacol.conectacol.Utilities.ApplicationConstants.SERVER_ERROR;

@Service
public class SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    private MyResponseUtility response;


    public MyResponseUtility createSector(Sector sector) {

        try {
            response = new MyResponseUtility();
            response.data = sectorRepository.save(sector);
            response.status = HttpStatus.CREATED.value();
            return response;

        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }
    }

    public MyResponseUtility findById(int idSector) {
        try {
            response = new MyResponseUtility();
            response.data = sectorRepository.findById(idSector);
            response.status = HttpStatus.OK.value();
            return response;
        } catch (Exception e) {
            response.message = SERVER_ERROR;
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
            return response;
        }

    }
}
