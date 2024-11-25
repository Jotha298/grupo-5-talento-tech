package talento.tech.conectacol.conectacol.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import talento.tech.conectacol.conectacol.Entities.Rol;
import talento.tech.conectacol.conectacol.Services.RolService;
import talento.tech.conectacol.conectacol.utilities.MyResponseUtility;

import java.util.Optional;

@RestController
@RequestMapping("/conectacol/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @Autowired
    private MyResponseUtility response;

    @PostMapping
    public ResponseEntity<MyResponseUtility> saveRol(@RequestBody Rol rol){
        response = rolService.saveRol(rol);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyResponseUtility> findRolById(@PathVariable int id){
        response = rolService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));

    }
}