package tn.esprit.rh.achat.mapper;

import tn.esprit.rh.achat.dto.FactureDTO;
import tn.esprit.rh.achat.entities.Facture;
import java.util.List;
import java.util.stream.Collectors;

public class FactureMapper {
    
    public static FactureDTO toDTO(Facture entity) {
        if (entity == null) return null;
        
        FactureDTO dto = new FactureDTO();
        dto.setIdFacture(entity.getIdFacture());
        dto.setMontantRemise(entity.getMontantRemise());
        dto.setMontantFacture(entity.getMontantFacture());
        dto.setDateCreationFacture(entity.getDateCreationFacture());
        dto.setDateDerniereModificationFacture(entity.getDateDerniereModificationFacture());
        dto.setArchivee(entity.getArchivee());
        
        if (entity.getFournisseur() != null) {
            dto.setFournisseurId(entity.getFournisseur().getIdFournisseur());
        }
        
        return dto;
    }
    
    public static Facture toEntity(FactureDTO dto) {
        if (dto == null) return null;
        
        Facture entity = new Facture();
        entity.setIdFacture(dto.getIdFacture());
        entity.setMontantRemise(dto.getMontantRemise());
        entity.setMontantFacture(dto.getMontantFacture());
        entity.setDateCreationFacture(dto.getDateCreationFacture());
        entity.setDateDerniereModificationFacture(dto.getDateDerniereModificationFacture());
        entity.setArchivee(dto.getArchivee());
        
        return entity;
    }
    
    public static List<FactureDTO> toDTOList(List<Facture> entities) {
        if (entities == null) return null;
        return entities.stream().map(FactureMapper::toDTO).collect(Collectors.toList());
    }
}