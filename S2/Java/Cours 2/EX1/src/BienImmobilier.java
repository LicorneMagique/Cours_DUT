public class BienImmobilier {
    private static int compteur = 0;
    private int reference = 0;
    private double prix = 0.0;
    private boolean location = false;
    private boolean vente = false;
    private String proprietaire = "Il n'y a pas de proprietaire";
    private String locataire = "Il n'y a pas de locataire";
     
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
        return proprietaire;
    }
    
    public String getLocataire() {
        return locataire;
    }
    
    public void setLocation(String nomLocataire) {
        locataire = nomLocataire;
        location = true;
        vente = false;
        prix = 0.0;
    }
    
    public void setFinLocation() {
        locataire = "Il n'y a pas de locataire";
        location = false;
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