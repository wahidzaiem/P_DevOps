package tn.esprit.rh.achat.dto;

public class FournisseurDTO {
    private Long idFournisseur;
    private String code;
    private String libelle;
    private String secteurActivite;
    private Long detailFournisseurId;
    
    public FournisseurDTO() {}
    
    // Getters
    public Long getIdFournisseur() {
        return idFournisseur;
    }
    
    public void setIdFournisseur(Long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getLibelle() {
        return libelle;
    }
    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    public String getSecteurActivite() {
        return secteurActivite;
    }
    
    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }
    
    public Long getDetailFournisseurId() {
        return detailFournisseurId;
    }
    
    public void setDetailFournisseurId(Long detailFournisseurId) {
        this.detailFournisseurId = detailFournisseurId;
    }
}