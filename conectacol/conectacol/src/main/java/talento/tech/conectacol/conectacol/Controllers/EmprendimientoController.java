package talento.tech.conectacol.conectacol.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import talento.tech.conectacol.conectacol.Entities.DTO.EmprendimientoDTO;
import talento.tech.conectacol.conectacol.Services.EmprendimientoService;
import talento.tech.conectacol.conectacol.Utilities.MyResponseUtility;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/conectacol/emprendimiento")
public class EmprendimientoController {

    @Autowired
    private EmprendimientoService emprendimientoService;

    @Autowired
    private MyResponseUtility response;

    @PostMapping
    public ResponseEntity<MyResponseUtility> createEntrepreneurship( @RequestBody EmprendimientoDTO emprendimientoDTO )  {
        response = emprendimientoService.createEntrepreneurship(emprendimientoDTO);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }

    @GetMapping("/{idEmprendimiento}")
    public ResponseEntity<MyResponseUtility> finById( @PathVariable int idEmprendimiento ){
        response = emprendimientoService.findById( idEmprendimiento );
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }

    @GetMapping("/por-emprendedor/{emprendedorId}")
    public ResponseEntity<MyResponseUtility> findEntrepreneurshipByIdEnterpreneur( @PathVariable int emprendedorId ){
        response = emprendimientoService.findEntrepreneurshipByIdEnterpreneur(emprendedorId);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }

    @GetMapping("/todos")
    public ResponseEntity<MyResponseUtility> getAllEntrepreneurships(){
        response = emprendimientoService.getAllEntrepreneurships();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyResponseUtility> updateEmprendimiento(
            @PathVariable Integer id,
            @RequestBody EmprendimientoDTO emprendimientoDTO
    ) {
        response = emprendimientoService.updateEntrepreneurships(id, emprendimientoDTO);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MyResponseUtility> deleteEntrepreneurships(@PathVariable int id){
        response = emprendimientoService.deleteEntrepreneurships(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }
}
