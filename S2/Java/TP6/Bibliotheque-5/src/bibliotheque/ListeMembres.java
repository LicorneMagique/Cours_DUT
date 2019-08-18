package bibliotheque;

import java.util.ArrayList;

public class ListeMembres {
    
    ArrayList<MembreBibliotheque> liste;
    private int dernier;
    
    public ListeMembres() {
        this.liste = new ArrayList<>();
        this.liste.add(null);
        this.dernier = 0;
    }
    
    public int getDernier() {
        return this.dernier;
    }
    
    public boolean ajouterMembre(MembreBibliotheque membre) {
        if (membre != null
                && !membre.getNom().equals("")
                && !membre.getPrenom().equals("")
                && !membre.getTel().equals("")
                && !membre.getAdresse().equals("")) {
            this.liste.add(++this.dernier, membre); //ajouter le membre en fin de liste
            return true;
        }
        return false;
    }
    
    public MembreBibliotheque getMembre(int numAbonne) {
        for (int i = 1; i <= this.dernier; i++) { //pour tous les membre de la liste
            if (this.liste.get(i).getNumAbonne() == numAbonne) { //si les num correspondent
                return this.liste.get(i);
            }
        }
        return null;
    }
    
    public String toString(int numAbonne) { //toString d'un membre connu par son numéro d'abonné
        if (getMembre(numAbonne) != null) {
            return getMembre(numAbonne).toString();
        }
        return "aucun";
    }
    
    @Override
    public String toString() { //toString minimum sur une ligne pour tous les membres
        String chaine = "";
        for (int i = 1; i <= this.dernier; i++) {
            chaine += "Membre abonné n°" + this.liste.get(i).getNumAbonne() + " : "
                + this.liste.get(i).getNom() + " " + this.liste.get(i).getPrenom() + "\n";
        }
        return chaine;
    }
    
}
