package talento.tech.conectacol.conectacol.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import talento.tech.conectacol.conectacol.Entities.Sector;
import talento.tech.conectacol.conectacol.Services.SectorService;
import talento.tech.conectacol.conectacol.utilities.MyResponseUtility;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/conectacol/sector")
public class SectorController {
    @Autowired
    private SectorService sectorService;

    @Autowired
    private MyResponseUtility response;

    @PostMapping
    public ResponseEntity<MyResponseUtility> createSector(@RequestBody Sector sector)  {
        response = sectorService.createSector(sector);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }
    @GetMapping("/{idSector}")
    public ResponseEntity<MyResponseUtility> finById(@PathVariable int idSector){
        response = sectorService.findById(idSector);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }


}
