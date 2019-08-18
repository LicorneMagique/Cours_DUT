package bibliotheque;

public class MembreEtudiant extends MembreBibliotheque {
    
    public MembreEtudiant(String nom , String prenom, String tel, String adresse) {
        super(nom , prenom, tel, adresse);
    }
    
    @Override
    public boolean peutEmprunterAutreDocument() {
        return super.getNbDocEmprunte() < 4;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nType de membre : membre étudiant";
    }
    
}
