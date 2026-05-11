package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.dto.ReglementDTO;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.mapper.ReglementMapper;
import tn.esprit.rh.achat.services.IReglementService;

import java.util.List;

@RestController
@Api(tags = "Gestion des règlements")
@RequestMapping("/reglement")
public class ReglementRestController {

    @Autowired
    IReglementService reglementService;

    @GetMapping("/retrieve-all-reglements")
    @ResponseBody
    public List<ReglementDTO> getReglements() {
        return ReglementMapper.toDTOList(reglementService.retrieveAllReglements());
    }

    @GetMapping("/retrieve-reglement/{reglement-id}")
    @ResponseBody
    public ReglementDTO retrieveReglement(@PathVariable("reglement-id") Long reglementId) {
        return ReglementMapper.toDTO(reglementService.retrieveReglement(reglementId));
    }

    @PostMapping("/add-reglement")
    @ResponseBody
    public ReglementDTO addReglement(@RequestBody ReglementDTO reglementDTO) {
        Reglement entity = ReglementMapper.toEntity(reglementDTO);
        Reglement savedEntity = reglementService.addReglement(entity);
        return ReglementMapper.toDTO(savedEntity);
    }

    // Note: deleteReglement et updateReglement n'existent pas dans IReglementService
    // Les méthodes suivantes ne sont pas disponibles, commentez-les ou supprimez-les
}