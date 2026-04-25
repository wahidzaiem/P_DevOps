package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.dto.FournisseurDTO;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.mapper.FournisseurMapper;
import tn.esprit.rh.achat.services.IFournisseurService;

import java.util.List;

@RestController
@Api(tags = "Gestion des fournisseurs")
@RequestMapping("/fournisseur")
@CrossOrigin(origins = "http://localhost:4200")
public class FournisseurRestController {

    @Autowired
    IFournisseurService fournisseurService;

    @GetMapping("/retrieve-all-fournisseurs")
    @ResponseBody
    public List<FournisseurDTO> getFournisseurs() {
        return FournisseurMapper.toDTOList(fournisseurService.retrieveAllFournisseurs());
    }

    @GetMapping("/retrieve-fournisseur/{fournisseur-id}")
    @ResponseBody
    public FournisseurDTO retrieveFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
        return FournisseurMapper.toDTO(fournisseurService.retrieveFournisseur(fournisseurId));
    }

    @PostMapping("/add-fournisseur")
    @ResponseBody
    public FournisseurDTO addFournisseur(@RequestBody FournisseurDTO fournisseurDTO) {
        Fournisseur entity = FournisseurMapper.toEntity(fournisseurDTO);
        Fournisseur savedEntity = fournisseurService.addFournisseur(entity);
        return FournisseurMapper.toDTO(savedEntity);
    }

    @DeleteMapping("/remove-fournisseur/{fournisseur-id}")
    @ResponseBody
    public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
        fournisseurService.deleteFournisseur(fournisseurId);
    }

    @PutMapping("/modify-fournisseur")
    @ResponseBody
    public FournisseurDTO modifyFournisseur(@RequestBody FournisseurDTO fournisseurDTO) {
        Fournisseur entity = FournisseurMapper.toEntity(fournisseurDTO);
        Fournisseur updatedEntity = fournisseurService.updateFournisseur(entity);
        return FournisseurMapper.toDTO(updatedEntity);
    }
}