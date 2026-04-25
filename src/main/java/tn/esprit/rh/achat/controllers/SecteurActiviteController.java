package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.dto.SecteurActiviteDTO;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.mapper.SecteurActiviteMapper;
import tn.esprit.rh.achat.services.ISecteurActiviteService;

import java.util.List;

@RestController
@Api(tags = "Gestion des secteurs d'activité")
@RequestMapping("/secteurActivite")
public class SecteurActiviteController {

    @Autowired
    ISecteurActiviteService secteurActiviteService;

    @GetMapping("/retrieve-all-secteurActivite")
    @ResponseBody
    public List<SecteurActiviteDTO> getSecteurActivites() {
        return SecteurActiviteMapper.toDTOList(secteurActiviteService.retrieveAllSecteurActivites());
    }

    @GetMapping("/retrieve-secteurActivite/{secteurActivite-id}")
    @ResponseBody
    public SecteurActiviteDTO retrieveSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
        return SecteurActiviteMapper.toDTO(secteurActiviteService.retrieveSecteurActivite(secteurActiviteId));
    }

    @PostMapping("/add-secteurActivite")
    @ResponseBody
    public SecteurActiviteDTO addSecteurActivite(@RequestBody SecteurActiviteDTO secteurActiviteDTO) {
        SecteurActivite entity = SecteurActiviteMapper.toEntity(secteurActiviteDTO);
        SecteurActivite savedEntity = secteurActiviteService.addSecteurActivite(entity);
        return SecteurActiviteMapper.toDTO(savedEntity);
    }

    @DeleteMapping("/remove-secteurActivite/{secteurActivite-id}")
    @ResponseBody
    public void removeSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
        secteurActiviteService.deleteSecteurActivite(secteurActiviteId);
    }

    @PutMapping("/modify-secteurActivite")
    @ResponseBody
    public SecteurActiviteDTO modifySecteurActivite(@RequestBody SecteurActiviteDTO secteurActiviteDTO) {
        SecteurActivite entity = SecteurActiviteMapper.toEntity(secteurActiviteDTO);
        SecteurActivite updatedEntity = secteurActiviteService.updateSecteurActivite(entity);
        return SecteurActiviteMapper.toDTO(updatedEntity);
    }
}