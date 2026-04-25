package tn.esprit.rh.achat.mapper;

import tn.esprit.rh.achat.dto.ReglementDTO;
import tn.esprit.rh.achat.entities.Reglement;
import java.util.List;
import java.util.stream.Collectors;

public class ReglementMapper {
    
    public static ReglementDTO toDTO(Reglement entity) {
        if (entity == null) return null;
        
        ReglementDTO dto = new ReglementDTO();
        dto.setIdReglement(entity.getIdReglement());
        dto.setMontantPaye(entity.getMontantPaye());
        dto.setMontantRestant(entity.getMontantRestant());
        dto.setPayee(entity.getPayee());
        dto.setDateReglement(entity.getDateReglement());
        
        if (entity.getFacture() != null) {
            dto.setFactureId(entity.getFacture().getIdFacture());
        }
        
        return dto;
    }
    
    public static Reglement toEntity(ReglementDTO dto) {
        if (dto == null) return null;
        
        Reglement entity = new Reglement();
        entity.setIdReglement(dto.getIdReglement());
        entity.setMontantPaye(dto.getMontantPaye());
        entity.setMontantRestant(dto.getMontantRestant());
        entity.setPayee(dto.getPayee());
        entity.setDateReglement(dto.getDateReglement());
        
        return entity;
    }
    
    public static List<ReglementDTO> toDTOList(List<Reglement> entities) {
        if (entities == null) return null;
        return entities.stream().map(ReglementMapper::toDTO).collect(Collectors.toList());
    }
}