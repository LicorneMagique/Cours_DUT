public class BienImmobilier {
    private static int compteur = 0;
    private int reference = 0;
    private double prix = 0.0;
    private boolean location = false;
    private boolean vente = false;
    private Proprietaire proprietaire = null;
    private Locataire locataire = null;
    
    public BienImmobilier(Proprietaire newProprietaire) {
        reference = ++compteur;
        proprietaire = newProprietaire;
    }
    public int getReference() {
        return reference;
    }
    
    public double getPrix() {
        return prix;
    }
    
    public boolean getLocation() {
        return location;
    }
    
    public boolean getVente() {
        return vente;
    }
    
    public String getProprietaire() {
        return proprietaire.toString();
    }
    
    public String getLocataire() {
        return locataire.toString();
    }
    
    public void setLocation(Locataire newLocataire) {
        locataire = newLocataire;
        location = true;
        vente = false;
        prix = 0.0;
    }
    
    public void setFinLocation() {
        locataire = null;
        location = false;
    }
    
    public void setVente(double prixPropose) {
        if (prixPropose <= 0) {
            System.out.println("Le prix " + prixPropose + " n'est pas conforme.");
            vente = false;
        }
        else {
            prix = prixPropose;
            vente = true;
        }
    }
    
    public void setVendu(Proprietaire newProprietaire) {
        proprietaire = newProprietaire;
        vente = false;
        location = false;
    }
    
    public String toString() {
        return ("Référence : " + reference +
                "\nPrix : " + prix +
                "\nEtat location : " + location +
                "\nEtat vente : " + vente +
                "\n" + proprietaire +
                "\n" + locataire);
    }
    
}