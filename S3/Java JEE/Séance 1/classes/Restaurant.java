public class Restaurant {
    
    // Liste des attributs
    private String nom;
    private String adresse;
    private int place; // Le nombre de couvert maximum
    private String typeCuisine;
    private Proprietaire proprio;
    
    // Constructeur
    public Restaurant(String newNom, String newAdresse, int newPlace, String newTypeCuisine, Proprietaire newProprio) {
        this.nom = newNom;
        this.adresse = newAdresse;
        this.place = newPlace;
        this.typeCuisine = newTypeCuisine;
        this.proprio = newProprio;
    }
    
    // Getters/Setters
    
    // Nom
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String newNom) {
        this.nom = newNom;
    }
    
    // Adresse
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String newAdresse) {
        this.adresse = newAdresse;
    }
    
    // Nombre de place
    public int getPlace() {
        return this.place;
    }
    
    public void setPlace(int newPlace) {
        this.place = newPlace;
    }
    
    // Type de cuisine
    public String getTypeCuisine() {
        return this.typeCuisine;
    }
    
    public void setTypeCuisine(String newTypeCuisine) {
        this.typeCuisine = newTypeCuisine;
    }
    
    // Propriétaire
    public Proprietaire getProprio() {
        return this.proprio;
    }
    
    public void setProprio(Proprietaire newProprio) {
        this.proprio = newProprio;
    }
    
    // Fonctions
}
