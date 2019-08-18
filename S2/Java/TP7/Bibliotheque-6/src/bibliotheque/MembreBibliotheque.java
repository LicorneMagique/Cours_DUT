package bibliotheque;

public class MembreBibliotheque {
    private String nom = null;
    private String prenom = null;
    private String tel = null; //numéro de téléphone du membre
    private String adresse = null;
    private int num = 0; //numéro d'abonné
    private static int dernierNumeroAbonne = 0;
    private int nbDocEmprunte;
    
    public MembreBibliotheque(String newNom , String newPrenom, String newTel, String newAdresse) {
        this.nom = newNom;
        this.prenom = newPrenom;
        this.tel = newTel;
        this.adresse = newAdresse;
        this.num = ++dernierNumeroAbonne;
        this.nbDocEmprunte = 0;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public boolean setNom(String newNom) {
        if (newNom != null && !newNom.equals("") //si la nouvelle valeur du nom n'est pas "null"
                && !newNom.equals(this.nom)) { //et qu'elle est différente de l'ancienne
            this.nom = newNom; //alors changer la valeur du nom
            return true;
        }
        return false;
    }
    
    public String getPrenom() {
        return this.prenom;
    }
    
    public boolean setPrenom(String newPrenom) {
        if (newPrenom != null && !newPrenom.equals("") //si la nouvelle valeur du prénom n'est pas "null"
                && !newPrenom.equals(this.prenom)) { //et qu'elle est différente de l'ancienne
            this.prenom = newPrenom; //alors changer la valeur du prénom
            return true;
        }
        return false;
    }
    
    public String getTel() {
        return this.tel;
    }
    
    public boolean setTel(String newTel) {
        if (newTel != null && !newTel.equals("") //si la nouvelle valeur du téléphone n'est pas "null"
                && !newTel.equals(this.tel)) { //et qu'elle est différente de l'ancienne
            this.tel = newTel; //alors changer la valeur du téléphone
            return true;
        }
        return false;
    }
    
    public String getAdresse() {
        return this.adresse;
    }
    
    public boolean setAdresse(String newAdresse) {
        if (newAdresse != null && !newAdresse.equals("") //si la nouvelle valeur de l'adresse n'est pas "null"
                && !newAdresse.equals(this.adresse)) { //et qu'elle est différente de l'ancienne
            this.adresse = newAdresse; //alors changer la valeur de l'adresse
            return true;
        }
        return false;
    }
    
    public int getNumAbonne() {
        return this.num;
    }
    
    public int getNbDocEmprunte() {
        return this.nbDocEmprunte;
    }
    
    public void addDocEmprunte() {
        this.nbDocEmprunte ++;
    }
    
    public void removeDocEmprunte() {
        this.nbDocEmprunte --;
    }
    
    public boolean peutEmprunterAutreDocument() {
        return true;
    }
    
    @Override
    public String toString() {
        if (this == null) {
            return "rien";
        }
        return "Nom : " + this.nom +
               "\nPrénom : " + this.prenom +
               "\nTéléphone : " + this.tel +
               "\nAdresse : " + this.adresse +
               "\nNuméro d'abonné : " + this.num +
               "\nNombre de document(s) emprunté(s) : " + this.nbDocEmprunte;
    }

}