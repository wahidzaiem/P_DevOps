package tn.esprit.rh.achat.mapper;

import tn.esprit.rh.achat.dto.OperateurDTO;
import tn.esprit.rh.achat.entities.Operateur;
import java.util.List;
import java.util.stream.Collectors;

public class OperateurMapper {
    
    public static OperateurDTO toDTO(Operateur entity) {
        if (entity == null) return null;
        
        OperateurDTO dto = new OperateurDTO();
        dto.setIdOperateur(entity.getIdOperateur());
        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());
        dto.setPassword(entity.getPassword());
        return dto;
    }
    
    public static Operateur toEntity(OperateurDTO dto) {
        if (dto == null) return null;
        
        Operateur entity = new Operateur();
        entity.setIdOperateur(dto.getIdOperateur());
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setPassword(dto.getPassword());
        return entity;
    }
    
    public static List<OperateurDTO> toDTOList(List<Operateur> entities) {
        if (entities == null) return null;
        return entities.stream().map(OperateurMapper::toDTO).collect(Collectors.toList());
    }
}