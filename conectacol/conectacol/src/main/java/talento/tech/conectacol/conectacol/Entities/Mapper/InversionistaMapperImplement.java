package talento.tech.conectacol.conectacol.Entities.Mapper;


import org.springframework.stereotype.Component;
import talento.tech.conectacol.conectacol.Entities.DTO.InversionistaDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Inversionista;
import talento.tech.conectacol.conectacol.Entities.Domain.Usuario;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InversionistaMapperImplement implements InversionistaMapper{
    @Override
    public Inversionista toInversionista(InversionistaDTO inversionistaDTO, Usuario usuario) {
        if (inversionistaDTO == null || usuario == null) {
            return null;
        }

        Inversionista inversionista = new Inversionista();

        inversionista.setIdInversionista(inversionistaDTO.getIdInversionista());
        inversionista.setCapitalDisponible(inversionistaDTO.getCapitalDisponible());
        inversionista.setUsuario(usuario);

        return inversionista;
    }

    @Override
    public InversionistaDTO toInversionistaDTO(Inversionista inversionista) {
        if (inversionista == null) {
            return null;
        }

        InversionistaDTO inversionistaDTO = new InversionistaDTO();
        inversionistaDTO.setIdInversionista(inversionista.getIdInversionista());
        inversionistaDTO.setCapitalDisponible(inversionista.getCapitalDisponible());

        Usuario usuario = inversionista.getUsuario();
        if (usuario != null) {
            inversionistaDTO.setIdUsuario(usuario.getIdUsuario());
        }

        return inversionistaDTO;
    }

    @Override
    public List<InversionistaDTO> toInversionistaDTOs(List<Inversionista> inversionistas) {
        if (inversionistas == null || inversionistas.isEmpty()) {
            return List.of();
        }

        return inversionistas.stream()
                .map(this::toInversionistaDTO) // Mapear cada Emprendedor a EmprendedorDTO
                .collect(Collectors.toList());
    }
}
