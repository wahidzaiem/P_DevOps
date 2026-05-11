package tn.esprit.rh.achat.mapper;

import tn.esprit.rh.achat.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;

import java.util.List;
import java.util.stream.Collectors;

public class CategorieProduitMapper {

    // Entity → DTO
    public static CategorieProduitDTO toDTO(CategorieProduit entity) {
        if (entity == null) {
            return null;
        }

        return new CategorieProduitDTO(
                entity.getIdCategorieProduit(),
                entity.getCodeCategorie(),
                entity.getLibelleCategorie(),
                null
        );
    }

    // DTO → Entity
    public static CategorieProduit toEntity(CategorieProduitDTO dto) {
        if (dto == null) {
            return null;
        }

        CategorieProduit entity = new CategorieProduit();
        entity.setIdCategorieProduit(dto.getId());
        entity.setCodeCategorie(dto.getCode());
        entity.setLibelleCategorie(dto.getLibelle());

        return entity;
    }

    // List<Entity> → List<DTO>
    public static List<CategorieProduitDTO> toDTOList(List<CategorieProduit> entities) {
        if (entities == null) {
            return null;
        }

        return entities.stream()
                .map(CategorieProduitMapper::toDTO)
                .collect(Collectors.toList());
    }

    // List<DTO> → List<Entity>
    public static List<CategorieProduit> toEntityList(List<CategorieProduitDTO> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(CategorieProduitMapper::toEntity)
                .collect(Collectors.toList());
    }
}