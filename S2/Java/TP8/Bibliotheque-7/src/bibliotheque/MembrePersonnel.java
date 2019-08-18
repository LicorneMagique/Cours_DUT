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
    
    @Override
    public void docDisponible(DocBibliotheque doc) {
        System.out.println("Le document \"" + doc.getTitre() + "\" que vous avez réservé "
            + "est désormais disponible à l’emprunt au bureau des réservations");
    }
    
}

