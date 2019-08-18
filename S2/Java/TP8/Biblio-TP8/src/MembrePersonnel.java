public class MembrePersonnel extends MembreBibliotheque {
    
    public MembrePersonnel(String newNom, String newPrenom, String newNumTelephone, String newAdresse) {
        super(newNom, newPrenom, newNumTelephone, newAdresse);
    }
    
    @Override
    public void docDisponible(DocBibliotheque doc) {
        System.out.println("Le document " + doc.getTitre() + " qui a été réservé "
            + "est désormais disponible à l’emprunt au bureau des réservations");
    }
}
