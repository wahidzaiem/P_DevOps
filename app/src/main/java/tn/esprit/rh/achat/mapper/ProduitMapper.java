package tn.esprit.rh.achat.mapper;

import tn.esprit.rh.achat.dto.ProduitDTO;
import tn.esprit.rh.achat.entities.Produit;
import java.util.List;
import java.util.stream.Collectors;

public class ProduitMapper {
    
    public static ProduitDTO toDTO(Produit entity) {
        if (entity == null) return null;
        
        ProduitDTO dto = new ProduitDTO();
        dto.setIdProduit(entity.getIdProduit());
        dto.setCode(entity.getCodeProduit());        
        dto.setLibelle(entity.getLibelleProduit());  
        dto.setPrixUnitaire(entity.getPrix());       
        
        if (entity.getStock() != null) {
            dto.setStockId(entity.getStock().getIdStock());
        }
        
        if (entity.getCategorieProduit() != null) {
            dto.setCategorieProduitId(entity.getCategorieProduit().getIdCategorieProduit());
        }
        
        return dto;
    }
    
    public static Produit toEntity(ProduitDTO dto) {
        if (dto == null) return null;
        
        Produit entity = new Produit();
        entity.setIdProduit(dto.getIdProduit());
        entity.setCodeProduit(dto.getCode());       
        entity.setLibelleProduit(dto.getLibelle());  
        entity.setPrix(dto.getPrixUnitaire());      
        
        return entity;
    }
    
    public static List<ProduitDTO> toDTOList(List<Produit> entities) {
        if (entities == null) return null;
        return entities.stream().map(ProduitMapper::toDTO).collect(Collectors.toList());
    }
}