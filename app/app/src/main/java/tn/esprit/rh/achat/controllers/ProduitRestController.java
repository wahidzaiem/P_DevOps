package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.dto.ProduitDTO;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.mapper.ProduitMapper;
import tn.esprit.rh.achat.services.IProduitService;

import java.util.List;

@RestController
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {

    @Autowired
    IProduitService produitService;

    @GetMapping("/retrieve-all-produits")
    @ResponseBody
    public List<ProduitDTO> getProduits() {
        return ProduitMapper.toDTOList(produitService.retrieveAllProduits());
    }

    @GetMapping("/retrieve-produit/{produit-id}")
    @ResponseBody
    public ProduitDTO retrieveProduit(@PathVariable("produit-id") Long produitId) {
        return ProduitMapper.toDTO(produitService.retrieveProduit(produitId));
    }

    @PostMapping("/add-produit")
    @ResponseBody
    public ProduitDTO addProduit(@RequestBody ProduitDTO produitDTO) {
        Produit entity = ProduitMapper.toEntity(produitDTO);
        Produit savedEntity = produitService.addProduit(entity);
        return ProduitMapper.toDTO(savedEntity);
    }

    @DeleteMapping("/remove-produit/{produit-id}")
    @ResponseBody
    public void removeProduit(@PathVariable("produit-id") Long produitId) {
        produitService.deleteProduit(produitId);
    }

    @PutMapping("/modify-produit")
    @ResponseBody
    public ProduitDTO modifyProduit(@RequestBody ProduitDTO produitDTO) {
        Produit entity = ProduitMapper.toEntity(produitDTO);
        Produit updatedEntity = produitService.updateProduit(entity);
        return ProduitMapper.toDTO(updatedEntity);
    }
}