package tn.esprit.rh.achat.dto;

public class CategorieProduitDTO {
    private Long id;
    private String code;
    private String libelle;
    private Long produitId;
    
    // Constructeurs
    public CategorieProduitDTO() {}
    
    public CategorieProduitDTO(Long id, String code, String libelle, Long produitId) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.produitId = produitId;
    }
    
    // Getters et Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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
    
    public Long getProduitId() {
        return produitId;
    }
    
    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }
}