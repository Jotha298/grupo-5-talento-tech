package talento.tech.conectacol.conectacol.Entities.Mapper;

import org.springframework.stereotype.Component;
import talento.tech.conectacol.conectacol.Entities.DTO.ContactoDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Contacto;
import talento.tech.conectacol.conectacol.Entities.Domain.Emprendimiento;
import talento.tech.conectacol.conectacol.Entities.Domain.Inversionista;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ContactoMapperImplement implements ContactoMapper{


    @Override
    public Contacto toContacto(ContactoDTO contactoDTO, Emprendimiento emprendimiento, Inversionista inversionista) {
        if (contactoDTO == null || emprendimiento == null || inversionista == null) {
            return null;
        }

        Contacto contacto = new Contacto();
        contacto.setIdContacto(contactoDTO.getIdContacto());
        contacto.setFechaContacto(contactoDTO.getFechaContacto());
        contacto.setEmprendimiento(emprendimiento);
        contacto.setInversionista(inversionista);

        return contacto;
    }

    @Override
    public ContactoDTO toContactoDTO(Contacto contacto) {
        if (contacto == null) {
            return null;
        }

        ContactoDTO contactoDTO = new ContactoDTO();
        contactoDTO.setIdContacto(contacto.getIdContacto());
        contactoDTO.setFechaContacto(contacto.getFechaContacto());

        if (contacto.getEmprendimiento() != null) {
            contactoDTO.setIdEmprendimiento(contacto.getEmprendimiento().getIdEmprendimiento());
        }

        if (contacto.getInversionista() != null) {
            contactoDTO.setIdInversionista(contacto.getInversionista().getIdInversionista());
        }

        return contactoDTO;
    }

    @Override
    public List<ContactoDTO> toContactoDTOs(List<Contacto> contacto) {
        if (contacto == null || contacto.isEmpty()) {
            return List.of();
        }

        return contacto.stream()
                .map(this::toContactoDTO)
                .collect(Collectors.toList());
    }
}
