public class MembreBibliotheque {
 
    private String nom = null;
    private String prenom = null;
    private String numTelephone = null;
    private String adresse = null;
    private int numAbonne = 0;
    private static int dernierNumeroAbonne = 0;
    
    public MembreBibliotheque(String newNom, String newPrenom,
            String newNumTelephone, String newAdresse) {
        this.nom = newNom;
        this.prenom = newPrenom;
        this.numTelephone = newNumTelephone;
        this.adresse = newAdresse;
        this.numAbonne = dernierNumeroAbonne++;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public String getPrenom() {
        return this.prenom;
    }
    
    public String getNumTelephone() {
        return this.numTelephone;
    }
    
    public String getAdresse() {
        return this.adresse;
    }
    
    public int getNumAbonne() {
        return this.numAbonne;
    }
    
    public void setNom(String newNom) {
        this.nom = newNom;
    }
    
    public void setPrenom(String newPrenom) {
        this.prenom = newPrenom;
    }
    
    public void setNumTelephone(String newNumTelephone) {
        this.numTelephone = newNumTelephone;
    }
    
    public void setAdresse(String newAdresse) {
        this.adresse = newAdresse;
    }
    
    public void setNumAbonne(int newNumAbonne) {
        this.numAbonne = newNumAbonne;
    }
    
    @Override
    public String toString() {
        return "nom : " + this.nom +
                "\nprenom : " + this.prenom +
                "\nnumTelephone : " + this.numTelephone +
                "\nadresse : " + this.adresse +
                "\nnumAbonne : " + this.numAbonne;
    }
}
