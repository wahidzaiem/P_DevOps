package tn.esprit.rh.achat.mapper;

import tn.esprit.rh.achat.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;
import java.util.List;
import java.util.stream.Collectors;

public class CategorieProduitMapper {
    
    // Convertir Entity → DTO
    public static CategorieProduitDTO toDTO(CategorieProduit entity) {
        if (entity == null) {
            return null;
        }
        return new CategorieProduitDTO(
            entity.getId(),
            entity.getCode(),
            entity.getLibelle()
        );
    }
    
    // Convertir DTO → Entity
    public static CategorieProduit toEntity(CategorieProduitDTO dto) {
        if (dto == null) {
            return null;
        }
        CategorieProduit entity = new CategorieProduit();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setLibelle(dto.getLibelle());
        return entity;
    }
    
    // Convertir List<Entity> → List<DTO>
    public static List<CategorieProduitDTO> toDTOList(List<CategorieProduit> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
            .map(CategorieProduitMapper::toDTO)
            .collect(Collectors.toList());
    }
    
    // Convertir List<DTO> → List<Entity>
    public static List<CategorieProduit> toEntityList(List<CategorieProduitDTO> dtos) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
            .map(CategorieProduitMapper::toEntity)
            .collect(Collectors.toList());
    }
}