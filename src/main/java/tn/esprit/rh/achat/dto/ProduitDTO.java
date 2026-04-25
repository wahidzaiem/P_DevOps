package tn.esprit.rh.achat.dto;

public class ProduitDTO {
    private Long idProduit;
    private String code;
    private String libelle;
    private Float prixUnitaire;
    private Long stockId;
    private Long categorieProduitId;
    
    public ProduitDTO() {}
    
    // Getters et Setters
    public Long getIdProduit() {
        return idProduit;
    }
    
    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
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
    
    public Float getPrixUnitaire() {
        return prixUnitaire;
    }
    
    public void setPrixUnitaire(Float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    
    public Long getStockId() {
        return stockId;
    }
    
    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }
    
    public Long getCategorieProduitId() {
        return categorieProduitId;
    }
    
    public void setCategorieProduitId(Long categorieProduitId) {
        this.categorieProduitId = categorieProduitId;
    }
}