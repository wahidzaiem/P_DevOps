package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProduitServiceImplTest {

    @Mock
    private ProduitRepository produitRepository;

    @Mock
    private StockRepository stockRepository;

    @Mock
    private CategorieProduitRepository categorieProduitRepository;

    @InjectMocks
    private ProduitServiceImpl produitService;

    @Test
    void testRetrieveAllProduits() {
        Produit p1 = new Produit();
        p1.setCodeProduit("P001");
        Produit p2 = new Produit();
        p2.setCodeProduit("P002");
        when(produitRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Produit> result = produitService.retrieveAllProduits();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(produitRepository, times(1)).findAll();
    }

    @Test
    void testAddProduit() {
        Produit p = new Produit();
        p.setCodeProduit("P001");
        p.setLibelleProduit("Ordinateur");
        p.setPrix(1500f);
        when(produitRepository.save(any(Produit.class))).thenReturn(p);

        Produit result = produitService.addProduit(p);

        assertNotNull(result);
        assertEquals("P001", result.getCodeProduit());
        assertEquals(1500f, result.getPrix());
        verify(produitRepository, times(1)).save(p);
    }

    @Test
    void testRetrieveProduit() {
        Produit p = new Produit();
        p.setIdProduit(1L);
        p.setLibelleProduit("Clavier");
        when(produitRepository.findById(1L)).thenReturn(Optional.of(p));

        Produit result = produitService.retrieveProduit(1L);

        assertNotNull(result);
        assertEquals(1L, result.getIdProduit());
        assertEquals("Clavier", result.getLibelleProduit());
    }

    @Test
    void testRetrieveProduit_NotFound() {
        when(produitRepository.findById(99L)).thenReturn(Optional.empty());

        Produit result = produitService.retrieveProduit(99L);

        assertNull(result);
    }

    @Test
    void testUpdateProduit() {
        Produit p = new Produit();
        p.setIdProduit(1L);
        p.setPrix(2000f);
        when(produitRepository.save(p)).thenReturn(p);

        Produit result = produitService.updateProduit(p);

        assertNotNull(result);
        assertEquals(2000f, result.getPrix());
        verify(produitRepository, times(1)).save(p);
    }

    @Test
    void testDeleteProduit() {
        doNothing().when(produitRepository).deleteById(1L);

        produitService.deleteProduit(1L);

        verify(produitRepository, times(1)).deleteById(1L);
    }

    @Test
    void testAssignProduitToStock() {
        Produit p = new Produit();
        p.setIdProduit(1L);
        Stock s = new Stock();
        s.setIdStock(2L);
        when(produitRepository.findById(1L)).thenReturn(Optional.of(p));
        when(stockRepository.findById(2L)).thenReturn(Optional.of(s));
        when(produitRepository.save(any(Produit.class))).thenReturn(p);

        produitService.assignProduitToStock(1L, 2L);

        assertEquals(s, p.getStock());
        verify(produitRepository).save(p);
    }
}
