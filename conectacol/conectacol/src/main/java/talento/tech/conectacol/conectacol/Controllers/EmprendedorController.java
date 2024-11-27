package talento.tech.conectacol.conectacol.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import talento.tech.conectacol.conectacol.Entities.DTO.EmprendedorDTO;
import talento.tech.conectacol.conectacol.Services.EmprendedorService;
import talento.tech.conectacol.conectacol.Utilities.MyResponseUtility;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/conectacol/emprendedor")
public class EmprendedorController {

    @Autowired
    private EmprendedorService emprendedorService;

    @Autowired
    private MyResponseUtility response;

    @PostMapping
    public ResponseEntity<MyResponseUtility> createEnterpreneur(@RequestBody EmprendedorDTO emprendedorDTO)  {
        response = emprendedorService.createEnterpreneur(emprendedorDTO);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }

    @GetMapping("/{idEmprendedor}")
    public ResponseEntity<MyResponseUtility> finById(@PathVariable int idEmprendedor){
        response = emprendedorService.findById(idEmprendedor);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }

}
