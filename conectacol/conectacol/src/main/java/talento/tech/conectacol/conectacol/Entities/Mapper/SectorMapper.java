package talento.tech.conectacol.conectacol.Entities.Mapper;


import talento.tech.conectacol.conectacol.Entities.DTO.SectorDTO;
import talento.tech.conectacol.conectacol.Entities.Domain.Sector;

import java.util.List;

public interface SectorMapper {

    Sector toSector(SectorDTO sectorDTO);

    SectorDTO toSectorDTO(Sector sector);

    List<SectorDTO> toSectorDTOs(List<Sector> sectors);

}
