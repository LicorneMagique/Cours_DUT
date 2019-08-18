package bibliotheque;

import java.util.ArrayList;

public abstract class DocBibliotheque {
    private String code; //code d'archivage
    private String titre;
    private String auteur; //auteur principal
    private int annee; //année de publication
    private int etatDoc;
    //sur les étagères = 0
    //sur la pile des retours = 1
    //sur la section "réservations" = 2
    //emprunté = 3
    private MembreBibliotheque membreQuiEmprunte;
    private Notifiable membreQuiReserve;
    private static int nbDocEmprunte = 0; //nombre de documents empruntés
    private static int nbDocPile = 0; //nombre de documents sur la pile des retours
    private static int nbDocReserve = 0; //nombre de documents réservés
    private static int nbDocSectionReservation = 0;
    
    public DocBibliotheque (String newCode, String newTitre, String newAuteur, int newAnnee) {
        this.code = newCode;
        this.titre = newTitre;
        this.auteur = newAuteur;
        this.annee = newAnnee;
        this.etatDoc = 0;
        this.membreQuiEmprunte = null;
        this.membreQuiReserve = null;
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
    
    public void setEtatDoc(int nb) { //pour  docURL
        this.etatDoc = nb;
    }
    
    public int getEtatDoc() {
        return this.etatDoc;
    }
    
    public MembreBibliotheque getMembreQuiEmprunte() {
        return this.membreQuiEmprunte;
    }
    
    public Notifiable getMembreQuiReserve() {
        return this.membreQuiReserve;
    }
    
    public static int getNbDocEmprunte() {
        return nbDocEmprunte;
    }
    
    public static int getNbDocPile() {
        return nbDocPile;
    }
    
    public static int getNbDocReserve() {
        return nbDocReserve;
    }
    
    public static int getNbDocSectionReservation() {
        return nbDocSectionReservation;
    }
    
    
    public boolean setURL(String newTxt) {
        return true;
    }

    public boolean setDescription(String newTxt) {
        return true;
    }

    public boolean setNbPage(int nbPage) {
        return true;
    }

    public boolean setNomEditeur(String newTxt) {
        return true;
    }

    public boolean setISBN(String newTxt) {
        return true;
    }
        
    public int getTypeDoc() {
        return 0; //DocBibliotheque
    }
    
    public boolean setMorceaux(ArrayList <String> newMorceaux) {
        return true;
    }
    
    public boolean emprunterDoc(MembreBibliotheque membre) {
        if (membre.peutEmprunterAutreDocument()) {
            if (this.etatDoc == 0) { //si le doc est sur les étagères (= 0)
                this.etatDoc = 3; //alors le doc est emprunté (= 3)
                this.membreQuiEmprunte = membre;
                this.membreQuiEmprunte.addDocEmprunte();
                nbDocEmprunte ++;
                return true;
            }
            if (this.etatDoc == 2 //ou si le doc est sur la section "réservations" (= 2)
                && this.membreQuiReserve.equals(membre)) { //et que l'emprunteur est le réserveur
                this.etatDoc = 3; //alors le doc est emprunté (= 3)
                this.membreQuiReserve = null; //alors réinitialiser le réserveur
                this.membreQuiEmprunte = membre; //et mettre à jour l'emprunteur
                this.membreQuiEmprunte.addDocEmprunte();
                nbDocEmprunte ++;
                nbDocReserve --;
                nbDocSectionReservation --;
                return true;
            }
        }
        return false;
    }
    
    public boolean retournerDoc() {
        if (this.etatDoc == 3) { //si le doc est emprunté (= 3)
            this.membreQuiEmprunte.removeDocEmprunte();
            if (this.membreQuiReserve != null) { //alors si le doc est réservé
                this.etatDoc = 2; //alors le doc est sur la section "réservations" (= 2)
                this.membreQuiEmprunte = null; //et réinitialiser l'emprunteur
                nbDocEmprunte --;
                nbDocSectionReservation ++;
                this.membreQuiReserve.docDisponible(this);
                return true;
            }
            this.etatDoc = 1; //sinon (non réservé) alors le doc est sur la pile des retours (= 1)
            nbDocEmprunte --;
            nbDocPile ++;
            return true;
        }
        return false;
    }
    
    public boolean getReserve() {
        return (this.membreQuiReserve != null); //"true" si le réserveur n'est pas "null"
    }
    
    public boolean reserverDoc(Notifiable membre) {
        if (this.etatDoc == 3 //si le doc est emprunté (= 3)
                && this.membreQuiReserve == null //et le doc n'est pas déjà réservé
                && this.membreQuiEmprunte != membre) {
            this.membreQuiReserve = membre; //alors le doc est réservé
            nbDocReserve ++;
            return true;
        }
        return false;
    }
    
    public boolean annulerReservation(Notifiable membre) {
        if (membre.equals(this.membreQuiReserve)) { //si le doc est réservé par l'annuleur
            if (this.etatDoc == 3) { //alors si le doc est emprunté (= 3)
                this.membreQuiReserve = null; //alors le doc n'a plus de réserveur
                nbDocReserve --;
                return true;
            }
            //sinon si le doc est sur la section "réservations" (= 2)
            this.membreQuiReserve = null; //alors le doc n'est plus réservé
            this.etatDoc = 1; //et le doc est sur le pile des retours (= 1)
            nbDocReserve --;
            nbDocSectionReservation --;
            nbDocPile ++;
            return true;
        }
        return false;
    }
    
    public boolean rangerDoc() {
        if (this.etatDoc == 1) { //si le doc est sur la pile des retours (= 1)
            this.etatDoc = 0; //alors le doc est sur les étagères (= 0)
            nbDocPile --;
            return true;
        }
        return false;
    }

    
    public String toStringOneLine() {
        return "\"" + this.titre
                + "\" de " + this.auteur;
    }
    
    @Override
    public String toString() {
        return "Code d'archivage : " + this.code +
                "\nTitre : " + this.titre +
                "\nAuteur principal : " + this.auteur +
                "\nAnnée de publication : " + this.annee +
                "\nMembre qui emprunte : \n" + membreToString(this.membreQuiEmprunte) +
                "\nMembre qui réserve : \n" + membreToString(this.membreQuiReserve);
    }
    
    public String membreToString(MembreBibliotheque membre) {
        if (membre == null) {
            return "aucun";
        }
        return membre.toString();
    }
    
    public String membreToString(Notifiable membre) {
        if (membre == null) {
            return "aucun";
        }
        return membre.toString();
    }

}
