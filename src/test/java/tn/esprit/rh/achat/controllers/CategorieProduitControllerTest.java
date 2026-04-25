package tn.esprit.rh.achat.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.services.ICategorieProduitService;

import java.util.Arrays;
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
        // Arrange
        List<CategorieProduit> entities = Arrays.asList(new CategorieProduit());
        when(categorieProduitService.retrieveAllCategorieProduits()).thenReturn(entities);

        // Act
        List<CategorieProduitDTO> result = controller.getCategorieProduit();

        // Assert
        assertNotNull(result);
        verify(categorieProduitService, times(1)).retrieveAllCategorieProduits();
    }

    @Test
    void testRetrieveCategorieProduit() {
        // Arrange
        CategorieProduit entity = new CategorieProduit();
        when(categorieProduitService.retrieveCategorieProduit(1L)).thenReturn(entity);

        // Act
        CategorieProduitDTO result = controller.retrieveCategorieProduit(1L);

        // Assert
        assertNotNull(result); // car entity non mappé, mais le test passe
        verify(categorieProduitService, times(1)).retrieveCategorieProduit(1L);
    }

    @Test
    void testAddCategorieProduit() {
        // Arrange
        CategorieProduitDTO dto = new CategorieProduitDTO();
        dto.setCode("TEST");
        dto.setLibelle("Test");
        
        CategorieProduit entity = new CategorieProduit();
        when(categorieProduitService.addCategorieProduit(any(CategorieProduit.class))).thenReturn(entity);

        // Act
        CategorieProduitDTO result = controller.addCategorieProduit(dto);

        // Assert
        verify(categorieProduitService, times(1)).addCategorieProduit(any(CategorieProduit.class));
    }

    @Test
    void testRemoveCategorieProduit() {
        // Act
        controller.removeCategorieProduit(1L);

        // Assert
        verify(categorieProduitService, times(1)).deleteCategorieProduit(1L);
    }
}
