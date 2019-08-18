import exceptions.EmprunterException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MembreEtudiant extends MembreBibliotheque {

    public MembreEtudiant(String newNom, String newPrenom, String newNumTelephone, String newAdresse) {
        super(newNom, newPrenom, newNumTelephone, newAdresse);
    }
    
    @Override
    public void docDisponible(DocBibliotheque doc) {
        
        System.out.println("Votre document est disponible."
                + "Désirez-vous l’emprunter ou non ? (oui/non) ");
        Scanner entree = new Scanner(System.in);
        String rep = entree.nextLine();
        if ("oui".equals(rep)) {
            try {
                doc.emprunter(this);
            } catch (EmprunterException ex) {
                Logger.getLogger(MembrePersonnel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
