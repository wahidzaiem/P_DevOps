package tn.esprit.rh.achat.dto;

import java.util.Date;
import java.util.List;

public class FactureDTO {
    private Long idFacture;
    private Float montantRemise;
    private Float montantFacture;
    private Date dateCreationFacture;
    private Date dateDerniereModificationFacture;
    private Boolean archivee;
    private Long fournisseurId;
    private List<Long> detailsFactureIds;
    
    // Constructeurs
    public FactureDTO() {}
    
    // Getters et Setters
    public Long getIdFacture() {
        return idFacture;
    }
    
    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }
    
    public Float getMontantRemise() {
        return montantRemise;
    }
    
    public void setMontantRemise(Float montantRemise) {
        this.montantRemise = montantRemise;
    }
    
    public Float getMontantFacture() {
        return montantFacture;
    }
    
    public void setMontantFacture(Float montantFacture) {
        this.montantFacture = montantFacture;
    }
    
    public Date getDateCreationFacture() {
        return dateCreationFacture;
    }
    
    public void setDateCreationFacture(Date dateCreationFacture) {
        this.dateCreationFacture = dateCreationFacture;
    }
    
    public Date getDateDerniereModificationFacture() {
        return dateDerniereModificationFacture;
    }
    
    public void setDateDerniereModificationFacture(Date dateDerniereModificationFacture) {
        this.dateDerniereModificationFacture = dateDerniereModificationFacture;
    }
    
    public Boolean getArchivee() {
        return archivee;
    }
    
    public void setArchivee(Boolean archivee) {
        this.archivee = archivee;
    }
    
    public Long getFournisseurId() {
        return fournisseurId;
    }
    
    public void setFournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
    }
    
    public List<Long> getDetailsFactureIds() {
        return detailsFactureIds;
    }
    
    public void setDetailsFactureIds(List<Long> detailsFactureIds) {
        this.detailsFactureIds = detailsFactureIds;
    }
}