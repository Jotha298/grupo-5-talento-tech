package talento.tech.conectacol.conectacol.Entities.Mapper;


import talento.tech.conectacol.conectacol.Entities.DTO.InversionistaDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Inversionista;
import talento.tech.conectacol.conectacol.Entities.Domain.Usuario;

import java.util.List;

public interface InversionistaMapper {

    Inversionista toInversionista(InversionistaDTO inversionistaDTO, Usuario usuario);

    InversionistaDTO toInversionistaDTO(Inversionista inversionista);

    List<InversionistaDTO> toInversionistaDTOs(List<Inversionista> inversionistas);
}
