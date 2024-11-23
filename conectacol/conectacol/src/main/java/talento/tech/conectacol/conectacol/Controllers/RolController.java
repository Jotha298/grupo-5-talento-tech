package talento.tech.conectacol.conectacol.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import talento.tech.conectacol.conectacol.Entities.Rol;
import talento.tech.conectacol.conectacol.Services.RolServices;

import java.util.Optional;

@RestController
@RequestMapping("/conectacol/rol")
public class RolController {

    @Autowired
    private RolServices rolServices;

    @PostMapping
    public ResponseEntity<Rol> saveRol(@RequestBody Rol rol){
        return new ResponseEntity<>(rolServices.saveRol(rol), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> findRolById(@PathVariable int id){
        Optional<Rol> roles = rolServices.findById(id);
        return roles
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
}
