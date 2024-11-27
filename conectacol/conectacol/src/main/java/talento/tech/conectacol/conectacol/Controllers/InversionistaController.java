package talento.tech.conectacol.conectacol.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import talento.tech.conectacol.conectacol.Entities.DTO.InversionistaDTO;
import talento.tech.conectacol.conectacol.Services.InversionistaService;
import talento.tech.conectacol.conectacol.Utilities.MyResponseUtility;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/conectacol/inversionista")
public class InversionistaController {

    @Autowired
    private InversionistaService inversionistaService;

    @Autowired
    private MyResponseUtility response;

    @PostMapping
    public ResponseEntity<MyResponseUtility> createInvestor(@RequestBody InversionistaDTO inversionistaDTO)  {
        response = inversionistaService.createInvestor(inversionistaDTO);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }

    @GetMapping("/{idInversionista}")
    public ResponseEntity<MyResponseUtility> finById(@PathVariable int idInversionista){
        response = inversionistaService.findById(idInversionista);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.status));
    }
}
