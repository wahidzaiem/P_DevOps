package tn.esprit.rh.achat.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.services.ICategorieProduitService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategorieProduitControllerTest {

    @Mock
    private ICategorieProduitService categorieProduitService;

    @InjectMocks
    private CategorieProduitController controller;

    @Test
    void testGetCategorieProduit() {
        List<CategorieProduit> mockEntities = new ArrayList<>();
        when(categorieProduitService.retrieveAllCategorieProduits()).thenReturn(mockEntities);
        List<CategorieProduitDTO> result = controller.getCategorieProduit();
        assertNotNull(result);
        verify(categorieProduitService).retrieveAllCategorieProduits();
    }

    @Test
    void testRetrieveCategorieProduit() {
        CategorieProduit mockEntity = new CategorieProduit();
        when(categorieProduitService.retrieveCategorieProduit(1L)).thenReturn(mockEntity);
        CategorieProduitDTO result = controller.retrieveCategorieProduit(1L);
        assertNotNull(result);
        verify(categorieProduitService).retrieveCategorieProduit(1L);
    }

    @Test
    void testAddCategorieProduit() {
        CategorieProduitDTO dto = new CategorieProduitDTO();
        dto.setCode("TEST");
        CategorieProduit savedEntity = new CategorieProduit();
        when(categorieProduitService.addCategorieProduit(any(CategorieProduit.class))).thenReturn(savedEntity);
        CategorieProduitDTO result = controller.addCategorieProduit(dto);
        assertNotNull(result);
        verify(categorieProduitService).addCategorieProduit(any(CategorieProduit.class));
    }

    @Test
    void testModifyCategorieProduit() {
        CategorieProduitDTO dto = new CategorieProduitDTO();
        dto.setId(1L);
        CategorieProduit updatedEntity = new CategorieProduit();
        when(categorieProduitService.updateCategorieProduit(any(CategorieProduit.class))).thenReturn(updatedEntity);
        CategorieProduitDTO result = controller.modifyCategorieProduit(dto);
        assertNotNull(result);
        verify(categorieProduitService).updateCategorieProduit(any(CategorieProduit.class));
    }

    @Test
    void testRemoveCategorieProduit() {
        controller.removeCategorieProduit(1L);
        verify(categorieProduitService).deleteCategorieProduit(1L);
    }
}
