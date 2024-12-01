package talento.tech.conectacol.conectacol.Entities.Mapper;

import org.springframework.stereotype.Component;
import talento.tech.conectacol.conectacol.Entities.DTO.SectorDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Sector;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SectorMapperImplement implements SectorMapper {

    @Override
    public Sector toSector(SectorDTO sectorDTO) {
        if (sectorDTO == null) {
            return null;
        }

        Sector sector = new Sector();
        sector.setNombre(sectorDTO.getNombre());
        return sector;
    }

    @Override
    public SectorDTO toSectorDTO(Sector sector) {
        if (sector == null) {
            return null;
        }

        SectorDTO sectorDTO = new SectorDTO();
        sectorDTO.setIdSector(sector.getIdSector());
        sectorDTO.setNombre(sector.getNombre());
        return sectorDTO;
    }

    @Override
    public List<SectorDTO> toSectorDTOs(List<Sector> sectors) {
        if (sectors == null || sectors.isEmpty()) {
            return List.of(); // Retorna una lista vacía si no hay sectors
        }

        return sectors.stream()
                .map(this::toSectorDTO) // Convierte cada Sector a SectorDTO
                .collect(Collectors.toList());
    }
}
