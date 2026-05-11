package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.repositories.FactureRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FournisseurServiceImplTest {

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Mock
    private DetailFournisseurRepository detailFournisseurRepository;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @Mock
    private FactureRepository factureRepository;

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @Test
    void testRetrieveAllFournisseurs() {
        Fournisseur f1 = new Fournisseur();
        f1.setCode("F001");
        Fournisseur f2 = new Fournisseur();
        f2.setCode("F002");
        when(fournisseurRepository.findAll()).thenReturn(Arrays.asList(f1, f2));

        List<Fournisseur> result = fournisseurService.retrieveAllFournisseurs();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(fournisseurRepository, times(1)).findAll();
    }

    @Test
    void testAddFournisseur() {
        Fournisseur f = new Fournisseur();
        f.setCode("F001");
        f.setLibelle("Fournisseur Test");
        f.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        when(fournisseurRepository.save(any(Fournisseur.class))).thenReturn(f);

        Fournisseur result = fournisseurService.addFournisseur(f);

        assertNotNull(result);
        assertEquals("F001", result.getCode());
        verify(fournisseurRepository, times(1)).save(any(Fournisseur.class));
    }

    @Test
    void testRetrieveFournisseur() {
        Fournisseur f = new Fournisseur();
        f.setIdFournisseur(1L);
        f.setLibelle("Fournisseur A");
        when(fournisseurRepository.findById(1L)).thenReturn(Optional.of(f));

        Fournisseur result = fournisseurService.retrieveFournisseur(1L);

        assertNotNull(result);
        assertEquals(1L, result.getIdFournisseur());
    }

    @Test
    void testRetrieveFournisseur_NotFound() {
        when(fournisseurRepository.findById(99L)).thenReturn(Optional.empty());

        Fournisseur result = fournisseurService.retrieveFournisseur(99L);

        assertNull(result);
    }

    @Test
    void testUpdateFournisseur() {
        Fournisseur f = new Fournisseur();
        f.setIdFournisseur(1L);
        f.setLibelle("Updated");
        when(fournisseurRepository.save(f)).thenReturn(f);

        Fournisseur result = fournisseurService.updateFournisseur(f);

        assertNotNull(result);
        assertEquals("Updated", result.getLibelle());
        verify(fournisseurRepository, times(1)).save(f);
    }

    @Test
    void testDeleteFournisseur() {
        doNothing().when(fournisseurRepository).deleteById(1L);

        fournisseurService.deleteFournisseur(1L);

        verify(fournisseurRepository, times(1)).deleteById(1L);
    }
}
