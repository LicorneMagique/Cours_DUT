public class Proprietaire {
    
    // Attributs    
    private String nom;
    private String prenom;
    private String adresse;
    private double salaire;
    
    // Constructeur
    public Proprietaire (String newNom, String newPrenom, String newAdresse, double newSalaire) {
        this.nom = newNom;
        this.prenom = newPrenom;
        this.adresse = newAdresse;
        this.salaire = newSalaire;
    }
    
    // Getters/Setters
    
    // Nom
    public String getNom() {
        return nom;
    }
    
    public void setNom(String newNom) {
        this.nom = newNom;
    }
    
    // Prénom
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String newPrenom) {
        this.prenom = newPrenom;
    }
    
    // Adresse
    public String getAdresse() {
        return adresse;
    }
    
    public void setAdresse (String newAdresse) {
        this.adresse = newAdresse;
    }
    
    // Salaire
    public double getSalaire () {
        return salaire;
    }
    
    public void setSalaire (double newSalaire) {
        this.salaire = newSalaire;
    }
    
    // Fonctions
    
        
}
