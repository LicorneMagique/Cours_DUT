package bibliotheque;

public class MembrePersonnel extends MembreBibliotheque {
    
    public MembrePersonnel(String nom , String prenom, String tel, String adresse) {
        super(nom , prenom, tel, adresse);
    }
    
    @Override
    public boolean peutEmprunterAutreDocument() {
        return super.getNbDocEmprunte() < 8;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nType de membre : membre personnel";
    }
    
}

