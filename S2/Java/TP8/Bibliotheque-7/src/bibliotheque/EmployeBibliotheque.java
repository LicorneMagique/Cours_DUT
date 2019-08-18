package bibliotheque;

import java.util.ArrayList;

public class EmployeBibliotheque implements Notifiable {
    
    static ArrayList<DocBibliotheque> docUtilises;
    private String ID;
    private String nom;
    
    public EmployeBibliotheque(String id, String nom) {
        this.ID = id;
        this.nom = nom;
    }
    
    public String getID() {
        return this.ID;
    }
    
    public boolean setID(String newID) {
        if (newID != null && !newID.equals(this.ID)
                && newID.length() <= 4) {
            this.ID = newID;
            return true;
        }
        return false;
    }
    
    public String getNom() {
        return this.ID;
    }
    
    public boolean setNom(String newNom) {
        if (newNom != null && !newNom.equals(this.nom)) {
            this.nom = newNom;
            return true;
        }
        return false;
    }
    
    @Override
    public void docDisponible(DocBibliotheque doc) {
        docUtilises.add(doc);
        CatalogueBibliotheque.enleverDoc(doc);
    }
    
}
