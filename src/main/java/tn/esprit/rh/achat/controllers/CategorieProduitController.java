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
    
    @GetMapping("/retrieve-all-categorieProduit")
    @ResponseBody
    public List<CategorieProduitDTO> getCategorieProduit() {
        List<CategorieProduit> list = categorieProduitService.retrieveAllCategorieProduits();
        return CategorieProduitMapper.toDTOList(list);
    }

    @GetMapping("/retrieve-categorieProduit/{categorieProduit-id}")
    @ResponseBody
    public CategorieProduitDTO retrieveCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
        CategorieProduit entity = categorieProduitService.retrieveCategorieProduit(categorieProduitId);
        return CategorieProduitMapper.toDTO(entity);
    }

    @PostMapping("/add-categorieProduit")
    @ResponseBody
    public CategorieProduitDTO addCategorieProduit(@RequestBody CategorieProduitDTO cpDTO) {
        CategorieProduit entity = CategorieProduitMapper.toEntity(cpDTO);
        CategorieProduit savedEntity = categorieProduitService.addCategorieProduit(entity);
        return CategorieProduitMapper.toDTO(savedEntity);
    }

    @DeleteMapping("/remove-categorieProduit/{categorieProduit-id}")
    @ResponseBody
    public void removeCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
        categorieProduitService.deleteCategorieProduit(categorieProduitId);
    }

    @PutMapping("/modify-categorieProduit")
    @ResponseBody
    public CategorieProduitDTO modifyCategorieProduit(@RequestBody CategorieProduitDTO categorieProduitDTO) {
        CategorieProduit entity = CategorieProduitMapper.toEntity(categorieProduitDTO);
        CategorieProduit updatedEntity = categorieProduitService.updateCategorieProduit(entity);
        return CategorieProduitMapper.toDTO(updatedEntity);
    }
}