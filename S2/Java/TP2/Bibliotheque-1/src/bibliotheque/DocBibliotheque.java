package bibliotheque;

public class DocBibliotheque {
    private String code; //code d'archivage
    private String titre;
    private String auteur; //auteur principal
    private int annee; //année de publication
    private int etatDoc;
    //sur les étagères = 0
    //sur la pile des retours = 1
    //sur la section "réservations" = 2
    //emprunté = 3
    private boolean reserve; //true si est réservé
    
    public DocBibliotheque (String newCode, String newTitre, String newAuteur, int newAnnee) {
        this.code = newCode;
        this.titre = newTitre;
        this.auteur = newAuteur;
        this.annee = newAnnee;
        this.etatDoc = 0;
        this.reserve = false;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public boolean setCode(String newCode) {
        if (newCode != null && !newCode.equals("") //si la nouvelle valeur du code n'est pas "null"
                && !newCode.equals(this.code)) { //et qu'elle est différente de l'ancienne
            this.code = newCode; //alors changer la valeur du code
            return true;
        }
        return false;
    }
        
    public String getTitre() {
        return this.titre;
    }
    
    public boolean setTitre(String newTitre) {
        if (newTitre != null && !newTitre.equals("") //si la nouvelle valeur du titre n'est pas "null"
                && !newTitre.equals(this.titre)) { //et qu'elle est différente de l'ancienne
            this.titre = newTitre; //alors changer la valeur du titre
            return true;
        }
        return false;
    }
    
    public String getAuteur() {
        return this.auteur;
    }
    
    public boolean setAuteur(String newAuteur) {
        if (newAuteur != null && !newAuteur.equals("") //si la nouvelle valeur de l'auteur n'est pas "null"
                && !newAuteur.equals(this.auteur)) { //et qu'elle est différente de l'ancienne
            this.auteur = newAuteur; //alors changer la valeur de l'auteur
            return true;
        }
        return false;
    }
    
    public int getAnnee() {
        return this.annee;
    }
    
    public boolean setAnnee(int newAnnee) {
        if (newAnnee != 0 //si la nouvelle valeur de l'année n'est pas vide (= 0)
                && newAnnee != this.annee) { //et qu'elle est différente de l'ancienne
            this.annee = newAnnee; //alors changer la valeur de l'année
            return true;
        }
        return false;
    }
    
    public int getEtatDoc() {
        return this.etatDoc;
    }
    
    public boolean emprunterDoc() {
        if (this.etatDoc == 0 //si le doc est sur les étagères (= 0)
                || this.etatDoc == 2) { //ou si le doc est sur la section "réservations" (= 2)
            this.etatDoc = 3; //alors le doc est emprunté (= 3)
            if (this.reserve) { //si le doc était réservé
                this.reserve = false; //alors il n'est plus réservé
            }
            return true;
        }
        return false;
    }
    
    public boolean retournerDoc() {
        if (this.etatDoc == 3) { //si le doc est emprunté (= 3)
            if (this.reserve) { //alors si le doc est réservé
                this.etatDoc = 2; //alors le doc est sur la section "réservations" (= 2)
                return true;
            }
            this.etatDoc = 1; //sinon (non réservé) alors le doc est sur la pile des retours (= 1)
            return true;
        }
        return false;
    }
    
    public boolean getReserve() {
        return this.reserve;
    }
    
    public boolean reserverDoc() {
        if (this.etatDoc == 3 //si le doc est emprunté (= 3)
                && this.reserve == false) { //et le doc n'est pas déjà réservé
            this.reserve = true; //alors le doc est réservé
            return true;
        }
        return false;
    }
    
    public boolean annulerReservation() {
        if (this.reserve) { //si le doc est réservé (= 2 ou = 3)
            if (this.etatDoc == 3) { //alors si le doc est emprunté (= 3)
                this.reserve = false; //alors le doc n'est plus réservé
                return true; //et retourner "true"
            }
            //sinon si le doc est sur la section "réservations" (= 2)
            this.reserve = false; //alors le doc n'est plus réservé
            this.etatDoc = 1; //et le doc est sur le pile des retours (= 1)
            return true;
        }
        return false;
    }
    
    public boolean rangerDoc() {
        if (this.etatDoc == 1) { //si le doc est sur la pile des retours (= 1)
            this.etatDoc = 0; //alors le doc est sur les étagères (= 0)
            return true;
        }
        return false;
    }
    
}
