package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.dto.OperateurDTO;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.mapper.OperateurMapper;
import tn.esprit.rh.achat.services.IOperateurService;

import java.util.List;

@RestController
@Api(tags = "Gestion des opérateurs")
@RequestMapping("/operateur")
public class OperateurController {

    @Autowired
    IOperateurService operateurService;

    @GetMapping("/retrieve-all-operateurs")
    @ResponseBody
    public List<OperateurDTO> getOperateurs() {
        return OperateurMapper.toDTOList(operateurService.retrieveAllOperateurs());
    }

    @GetMapping("/retrieve-operateur/{operateur-id}")
    @ResponseBody
    public OperateurDTO retrieveOperateur(@PathVariable("operateur-id") Long operateurId) {
        return OperateurMapper.toDTO(operateurService.retrieveOperateur(operateurId));
    }

    @PostMapping("/add-operateur")
    @ResponseBody
    public OperateurDTO addOperateur(@RequestBody OperateurDTO operateurDTO) {
        Operateur entity = OperateurMapper.toEntity(operateurDTO);
        Operateur savedEntity = operateurService.addOperateur(entity);
        return OperateurMapper.toDTO(savedEntity);
    }

    @DeleteMapping("/remove-operateur/{operateur-id}")
    @ResponseBody
    public void removeOperateur(@PathVariable("operateur-id") Long operateurId) {
        operateurService.deleteOperateur(operateurId);
    }

    @PutMapping("/modify-operateur")
    @ResponseBody
    public OperateurDTO modifyOperateur(@RequestBody OperateurDTO operateurDTO) {
        Operateur entity = OperateurMapper.toEntity(operateurDTO);
        Operateur updatedEntity = operateurService.updateOperateur(entity);
        return OperateurMapper.toDTO(updatedEntity);
    }
}