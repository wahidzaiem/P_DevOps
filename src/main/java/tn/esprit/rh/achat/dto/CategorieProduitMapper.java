package tn.esprit.rh.achat.mapper;

import tn.esprit.rh.achat.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;

public class CategorieProduitMapper {
    
    public static CategorieProduitDTO toDTO(CategorieProduit entity) {
        if (entity == null) return null;
        
        return new CategorieProduitDTO(
            entity.getId(),
            entity.getCode(),
            entity.getLibelle(),
            entity.getProduit() != null ? entity.getProduit().getId() : null
        );
    }
    
    public static CategorieProduit toEntity(CategorieProduitDTO dto) {
        if (dto == null) return null;
        
        CategorieProduit entity = new CategorieProduit();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setLibelle(dto.getLibelle());
        // Attention : il faut gérer la relation produit séparément
        return entity;
    }
}