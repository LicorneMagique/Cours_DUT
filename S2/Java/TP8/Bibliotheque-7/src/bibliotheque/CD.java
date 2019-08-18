package bibliotheque;

import static bibliotheque.TestBibliotheque.valide;
import java.util.ArrayList;

public class CD extends DocBibliotheque {
    ArrayList <String> morceaux;
    
    public CD(String code, String titre, String artiste, int annee, ArrayList <String> newMorceaux) {
        super(code, titre, artiste, annee);
        this.morceaux = new ArrayList<>();
        this.morceaux = newMorceaux;
    }
    
    @Override
    public boolean setMorceaux(ArrayList <String> newMorceaux) {
        if (valide(newMorceaux)) {
            this.morceaux = newMorceaux;
            return true;
        }
        return false;
    }
    
    @Override
    public int getTypeDoc() {
        return 1; //CD
    }
    
    @Override
    public String toString() {
        String resultat = "";
        resultat += "Code d'archivage : " + super.getCode() +
                "\nTitre : " + super.getTitre() +
                "\nArtiste principal : " + super.getAuteur() +
                "\nAnnée de publication : " + super.getAnnee() +
                "\nMembre qui emprunte : \n" + membreToString(super.getMembreQuiEmprunte()) +
                "\nMembre qui réserve : \n" + membreToString(super.getMembreQuiReserve()) +
                "\nListe des morceaux : ";
        for (int i = 0; i < morceaux.size(); i++) {
            resultat += "\n" + this.morceaux.get(i);
        }
        return resultat;
    }
    
}