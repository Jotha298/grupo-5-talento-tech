package talento.tech.conectacol.conectacol.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import talento.tech.conectacol.conectacol.Entities.DTO.ContactoDTO;
import talento.tech.conectacol.conectacol.Services.ContactoService;
import talento.tech.conectacol.conectacol.Utilities.MyResponseUtility;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/conectacol/contacto")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @Autowired
    private MyResponseUtility response;

    @PostMapping
    public ResponseEntity<MyResponseUtility> createContact(@RequestBody ContactoDTO contactoDTO)  {
        response = contactoService.createContact(contactoDTO);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }

    @GetMapping("/{idContacto}")
    public ResponseEntity<MyResponseUtility> finById(@PathVariable int idContacto){
        response = contactoService.findById(idContacto);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }
}
