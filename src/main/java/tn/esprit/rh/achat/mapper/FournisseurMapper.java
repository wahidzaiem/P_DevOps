package tn.esprit.rh.achat.mapper;

import tn.esprit.rh.achat.dto.FournisseurDTO;
import tn.esprit.rh.achat.entities.Fournisseur;
import java.util.List;
import java.util.stream.Collectors;

public class FournisseurMapper {
    
    public static FournisseurDTO toDTO(Fournisseur entity) {
        if (entity == null) return null;
        
        FournisseurDTO dto = new FournisseurDTO();
        dto.setIdFournisseur(entity.getIdFournisseur());
        dto.setCode(entity.getCode());
        dto.setLibelle(entity.getLibelle());
     
        
        if (entity.getDetailFournisseur() != null) {
            dto.setDetailFournisseurId(entity.getDetailFournisseur().getIdDetailFournisseur());
        }
        
        return dto;
    }
    
    public static Fournisseur toEntity(FournisseurDTO dto) {
        if (dto == null) return null;
        
        Fournisseur entity = new Fournisseur();
        entity.setIdFournisseur(dto.getIdFournisseur());
        entity.setCode(dto.getCode());
        entity.setLibelle(dto.getLibelle());
        
        return entity;
    }
    
    public static List<FournisseurDTO> toDTOList(List<Fournisseur> entities) {
        if (entities == null) return null;
        return entities.stream().map(FournisseurMapper::toDTO).collect(Collectors.toList());
    }
}