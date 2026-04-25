package tn.esprit.rh.achat.mapper;

import tn.esprit.rh.achat.dto.SecteurActiviteDTO;
import tn.esprit.rh.achat.entities.SecteurActivite;
import java.util.List;
import java.util.stream.Collectors;

public class SecteurActiviteMapper {
    
    public static SecteurActiviteDTO toDTO(SecteurActivite entity) {
        if (entity == null) return null;
        
        SecteurActiviteDTO dto = new SecteurActiviteDTO();
        dto.setIdSecteurActivite(entity.getIdSecteurActivite());
        dto.setCode(entity.getCode());
        dto.setLibelle(entity.getLibelle());
        return dto;
    }
    
    public static SecteurActivite toEntity(SecteurActiviteDTO dto) {
        if (dto == null) return null;
        
        SecteurActivite entity = new SecteurActivite();
        entity.setIdSecteurActivite(dto.getIdSecteurActivite());
        entity.setCode(dto.getCode());
        entity.setLibelle(dto.getLibelle());
        return entity;
    }
    
    public static List<SecteurActiviteDTO> toDTOList(List<SecteurActivite> entities) {
        if (entities == null) return null;
        return entities.stream().map(SecteurActiviteMapper::toDTO).collect(Collectors.toList());
    }
}