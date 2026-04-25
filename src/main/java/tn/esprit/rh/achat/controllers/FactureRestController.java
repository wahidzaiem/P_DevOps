package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.dto.FactureDTO;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.mapper.FactureMapper;
import tn.esprit.rh.achat.services.IFactureService;

import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "Gestion des factures")
@RequestMapping("/facture")
@CrossOrigin("*")
public class FactureRestController {

    @Autowired
    IFactureService factureService;

    @GetMapping("/retrieve-all-factures")
    @ResponseBody
    public List<FactureDTO> getFactures() {
        return FactureMapper.toDTOList(factureService.retrieveAllFactures());
    }

    @GetMapping("/retrieve-facture/{facture-id}")
    @ResponseBody
    public FactureDTO retrieveFacture(@PathVariable("facture-id") Long factureId) {
        return FactureMapper.toDTO(factureService.retrieveFacture(factureId));
    }

    @PostMapping("/add-facture")
    @ResponseBody
    public FactureDTO addFacture(@RequestBody FactureDTO factureDTO) {
        Facture entity = FactureMapper.toEntity(factureDTO);
        Facture savedEntity = factureService.addFacture(entity);
        return FactureMapper.toDTO(savedEntity);
    }

    @PutMapping("/cancel-facture/{facture-id}")
    @ResponseBody
    public void cancelFacture(@PathVariable("facture-id") Long factureId) {
        factureService.cancelFacture(factureId);
    }

    @GetMapping("/getFactureByFournisseur/{fournisseur-id}")
    @ResponseBody
    public List<FactureDTO> getFactureByFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
        return FactureMapper.toDTOList(factureService.getFacturesByFournisseur(fournisseurId));
    }

    @PutMapping(value = "/assignOperateurToFacture/{idOperateur}/{idFacture}")
    public void assignOperateurToFacture(@PathVariable("idOperateur") Long idOperateur, @PathVariable("idFacture") Long idFacture) {
        factureService.assignOperateurToFacture(idOperateur, idFacture);
    }

    @GetMapping(value = "/pourcentageRecouvrement/{startDate}/{endDate}")
    public float pourcentageRecouvrement(
            @PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return factureService.pourcentageRecouvrement(startDate, endDate);
    }

}