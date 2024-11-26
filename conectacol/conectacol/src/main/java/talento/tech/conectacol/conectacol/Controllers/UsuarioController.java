package talento.tech.conectacol.conectacol.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import talento.tech.conectacol.conectacol.Entities.DTO.UsuarioDTO;
import talento.tech.conectacol.conectacol.Entities.Sector;
import talento.tech.conectacol.conectacol.Entities.Usuario;
import talento.tech.conectacol.conectacol.Services.UsuarioService;
import talento.tech.conectacol.conectacol.utilities.MyResponseUtility;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/conectacol/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MyResponseUtility response;

    @PostMapping
    public ResponseEntity<MyResponseUtility> createUser(@RequestBody UsuarioDTO usuarioDTO)  {
        response = usuarioService.createUsers(usuarioDTO);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<MyResponseUtility> finById(@PathVariable int idUsuario){
        response = usuarioService.findById(idUsuario);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }


}