import java.util.ArrayList;

public class CD extends DocBibliotheque {
    ArrayList<String> listeMorceaux;
    
    public CD (String newCode, String newTitre,
            String newAuteur, int newAnnee) {
        super(newCode, newTitre, newAuteur, newAnnee);
        this.listeMorceaux = new ArrayList<>();
        
    }
}
