public class BienImmobilier {
    private static int compteur = 0;
    private int reference;
    private double prix;
    private boolean location;
    private boolean vente;
    private String proprietaire;
    private String locataire;
     
    
    public BienImmobilier() {
        reference = ++compteur;
    
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
        if (proprietaire == null) {
            return "Il n'y a pas de propriétaire.";
        }
        return proprietaire;
    }
    
    public String getLocataire() {
        if (locataire == null) {
            return "Il n'y a pas de locataire.";
        }
        return locataire;
    }
    
    public void setLocation(String nomLocataire) {
        locataire=nomLocataire;
        location=true;
        vente=false;
        prix=0.0;
    }
    
    public void setFinLocation() {
        locataire=null;
        location=false;
    }
    
    public void setVente(double prixPropose, String nomProprietaire) {
        if (prixPropose <= 0) {
            System.out.println("Le prix " + prixPropose + " n'est pas conforme.");
        }
        else {
            prix=prixPropose;
            System.out.println("Le nouveau prix " + prixPropose + " a été appliqué.");
        }
        proprietaire=nomProprietaire;
        vente=true;
    }
    
    public String toString() {
        return ("Référence : " + reference +
                "\nPrix : " + prix +
                "\nEtat location : " + location +
                "\nEtat vente : " + vente +
                "\nNom propriétaire : " + proprietaire +
                "\nNom locataire : " + locataire);
    }
    
}
