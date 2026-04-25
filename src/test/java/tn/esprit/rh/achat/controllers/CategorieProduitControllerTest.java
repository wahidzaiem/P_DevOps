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
        List<CategorieProduit> entities = new ArrayList<>();
        when(categorieProduitService.retrieveAllCategorieProduits()).thenReturn(entities);

        List<CategorieProduitDTO> result = controller.getCategorieProduit();

        assertNotNull(result);
        verify(categorieProduitService, times(1)).retrieveAllCategorieProduits();
    }

    @Test
    void testRetrieveCategorieProduit() {
        CategorieProduit entity = new CategorieProduit();
        when(categorieProduitService.retrieveCategorieProduit(1L)).thenReturn(entity);

        CategorieProduitDTO result = controller.retrieveCategorieProduit(1L);

        assertNotNull(result);
        verify(categorieProduitService, times(1)).retrieveCategorieProduit(1L);
    }

    @Test
    void testAddCategorieProduit() {
        CategorieProduitDTO dto = new CategorieProduitDTO();
        dto.setCode("TEST");
        dto.setLibelle("Test");
        
        CategorieProduit entity = new CategorieProduit();
        when(categorieProduitService.addCategorieProduit(any(CategorieProduit.class))).thenReturn(entity);

        CategorieProduitDTO result = controller.addCategorieProduit(dto);

        assertNotNull(result);
        verify(categorieProduitService, times(1)).addCategorieProduit(any(CategorieProduit.class));
    }

    @Test
    void testModifyCategorieProduit() {
        CategorieProduitDTO dto = new CategorieProduitDTO();
        dto.setId(1L);
        
        CategorieProduit entity = new CategorieProduit();
        when(categorieProduitService.updateCategorieProduit(any(CategorieProduit.class))).thenReturn(entity);

        CategorieProduitDTO result = controller.modifyCategorieProduit(dto);

        assertNotNull(result);
        verify(categorieProduitService, times(1)).updateCategorieProduit(any(CategorieProduit.class));
    }

    @Test
    void testRemoveCategorieProduit() {
        controller.removeCategorieProduit(1L);
        verify(categorieProduitService, times(1)).deleteCategorieProduit(1L);
    }
}
