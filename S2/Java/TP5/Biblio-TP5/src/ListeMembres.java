import java.util.ArrayList;

public class ListeMembres {
    ArrayList<MembreBibliotheque> membres;
    private int numero_membre = 0;
    
    public ListeMembres() {
         this.membres = new ArrayList<>();
    }
    
    public int getIndice() {
        return this.numero_membre;
    }
    
    public MembreBibliotheque getMembre(int numAbonne) {
        int i;
        if (numAbonne >= 0) {
            for (i=0; i<=numero_membre; i++) {
                if (this.membres.get(i).getNumAbonne() == numAbonne) {
                    return this.membres.get(i);
                }
            }
        }
        System.out.println("Erreur de numéro d'abonné");
        return null;
    }
    
    public void ajouterMembre(MembreBibliotheque newMembre) {
        this.membres.add(this.numero_membre++, newMembre);
    }
    
}
