package talento.tech.conectacol.conectacol.Entities.Mapper;

import talento.tech.conectacol.conectacol.Entities.DTO.ContactoDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Contacto;
import talento.tech.conectacol.conectacol.Entities.Domain.Emprendimiento;
import talento.tech.conectacol.conectacol.Entities.Domain.Inversionista;


import java.util.List;

public interface ContactoMapper {


    Contacto toContacto(ContactoDTO contactoDTO, Emprendimiento emprendimiento, Inversionista inversionista);

    ContactoDTO toContactoDTO(Contacto contacto);

    List<ContactoDTO> toContactoDTOs(List<Contacto> contacto);
}
