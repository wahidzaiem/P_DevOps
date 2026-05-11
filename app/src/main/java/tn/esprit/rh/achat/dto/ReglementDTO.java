package tn.esprit.rh.achat.dto;

import java.util.Date;

public class ReglementDTO {
    private Long idReglement;
    private Float montantPaye;
    private Float montantRestant;
    private Boolean payee;
    private Date dateReglement;
    private Long factureId;
    
    public ReglementDTO() {}
    
    // Getters et Setters
    public Long getIdReglement() {
        return idReglement;
    }
    
    public void setIdReglement(Long idReglement) {
        this.idReglement = idReglement;
    }
    
    public Float getMontantPaye() {
        return montantPaye;
    }
    
    public void setMontantPaye(Float montantPaye) {
        this.montantPaye = montantPaye;
    }
    
    public Float getMontantRestant() {
        return montantRestant;
    }
    
    public void setMontantRestant(Float montantRestant) {
        this.montantRestant = montantRestant;
    }
    
    public Boolean getPayee() {
        return payee;
    }
    
    public void setPayee(Boolean payee) {
        this.payee = payee;
    }
    
    public Date getDateReglement() {
        return dateReglement;
    }
    
    public void setDateReglement(Date dateReglement) {
        this.dateReglement = dateReglement;
    }
    
    public Long getFactureId() {
        return factureId;
    }
    
    public void setFactureId(Long factureId) {
        this.factureId = factureId;
    }
}