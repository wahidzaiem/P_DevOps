package tn.esprit.rh.achat.dto;

public class SecteurActiviteDTO {
    private Long idSecteurActivite;
    private String code;
    private String libelle;
    
    public SecteurActiviteDTO() {}
    
    // Getters et Setters
    public Long getIdSecteurActivite() {
        return idSecteurActivite;
    }
    
    public void setIdSecteurActivite(Long idSecteurActivite) {
        this.idSecteurActivite = idSecteurActivite;
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
}