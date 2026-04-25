package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.mapper.CategorieProduitMapper;
import tn.esprit.rh.achat.services.ICategorieProduitService;

import java.util.List;

@RestController
@Api(tags = "Gestion des categories Produit")
@RequestMapping("/categorieProduit")
public class CategorieProduitController {

    @Autowired
    ICategorieProduitService categorieProduitService;
    
    // http://localhost:8089/SpringMVC/categorieProduit/retrieve-all-categorieProduit
    @GetMapping("/retrieve-all-categorieProduit")
    @ResponseBody
    public List<CategorieProduitDTO> getCategorieProduit() {
        List<CategorieProduit> list = categorieProduitService.retrieveAllCategorieProduits();
        // Conversion Entity → DTO
        return CategorieProduitMapper.toDTOList(list);
    }

    // http://localhost:8089/SpringMVC/categorieProduit/retrieve-categorieProduit/8
    @GetMapping("/retrieve-categorieProduit/{categorieProduit-id}")
    @ResponseBody
    public CategorieProduitDTO retrieveCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
        CategorieProduit entity = categorieProduitService.retrieveCategorieProduit(categorieProduitId);
        // Conversion Entity → DTO
        return CategorieProduitMapper.toDTO(entity);
    }

    // http://localhost:8089/SpringMVC/categorieProduit/add-categorieProduit
    @PostMapping("/add-categorieProduit")
    @ResponseBody
    public CategorieProduitDTO addCategorieProduit(@RequestBody CategorieProduitDTO cpDTO) {
        // Conversion DTO → Entity pour le traitement
        CategorieProduit entity = CategorieProduitMapper.toEntity(cpDTO);
        CategorieProduit savedEntity = categorieProduitService.addCategorieProduit(entity);
        // Conversion Entity → DTO pour la réponse
        return CategorieProduitMapper.toDTO(savedEntity);
    }

    // http://localhost:8089/SpringMVC/categorieProduit/remove-categorieProduit/{categorieProduit-id}
    @DeleteMapping("/remove-categorieProduit/{categorieProduit-id}")
    @ResponseBody
    public void removeCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
        categorieProduitService.deleteCategorieProduit(categorieProduitId);
    }

    // http://localhost:8089/SpringMVC/categorieProduit/modify-categorieProduit
    @PutMapping("/modify-categorieProduit")
    @ResponseBody
    public CategorieProduitDTO modifyCategorieProduit(@RequestBody CategorieProduitDTO categorieProduitDTO) {
        // Conversion DTO → Entity pour le traitement
        CategorieProduit entity = CategorieProduitMapper.toEntity(categorieProduitDTO);
        CategorieProduit updatedEntity = categorieProduitService.updateCategorieProduit(entity);
        // Conversion Entity → DTO pour la réponse
        return CategorieProduitMapper.toDTO(updatedEntity);
    }
}