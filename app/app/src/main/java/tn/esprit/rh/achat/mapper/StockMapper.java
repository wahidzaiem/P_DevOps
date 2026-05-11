package tn.esprit.rh.achat.mapper;

import tn.esprit.rh.achat.dto.StockDTO;
import tn.esprit.rh.achat.entities.Stock;
import java.util.List;
import java.util.stream.Collectors;

public class StockMapper {
    
    public static StockDTO toDTO(Stock entity) {
        if (entity == null) return null;
        
        StockDTO dto = new StockDTO();
        dto.setIdStock(entity.getIdStock());
        dto.setLibelleStock(entity.getLibelleStock());
        dto.setQte(entity.getQte());
        dto.setQteMin(entity.getQteMin());
        return dto;
    }
    
    public static Stock toEntity(StockDTO dto) {
        if (dto == null) return null;
        
        Stock entity = new Stock();
        entity.setIdStock(dto.getIdStock());
        entity.setLibelleStock(dto.getLibelleStock());
        entity.setQte(dto.getQte());
        entity.setQteMin(dto.getQteMin());
        return entity;
    }
    
    public static List<StockDTO> toDTOList(List<Stock> entities) {
        if (entities == null) return null;
        return entities.stream().map(StockMapper::toDTO).collect(Collectors.toList());
    }
}