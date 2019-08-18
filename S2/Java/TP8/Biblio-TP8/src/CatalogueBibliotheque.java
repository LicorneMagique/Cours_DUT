import exceptions.EmprunterException;
import java.util.LinkedList;

public class CatalogueBibliotheque {
    
    LinkedList<DocBibliotheque> liste;
    private int dernier;
    
    public CatalogueBibliotheque() {
        this.liste = new LinkedList<>();
        this.liste.add(null);
        this.dernier = 0;
    }
    
    public int getDernier() {
        return this.dernier;
    }
    
    public DocBibliotheque getDoc(int indice){
        if (indice > 0 && indice <= this.dernier) { //si l'indice est possible
            return this.liste.get(indice);
        }
        return null;
    }
    
    public void ajouterDoc(DocBibliotheque doc) {
        this.liste.add(++this.dernier, doc);
    }
    
    public boolean enleverDoc(int indice) {
        if (indice > 0 && indice <= this.dernier) { //si l'indice est possible
            this.liste.remove(indice);
            dernier --;
            return true;
        }
        return false;
    }
    
    public void emprunterDoc(int indice, MembreBibliotheque membre) throws EmprunterException {
        this.liste.get(indice).emprunter(membre);
    }
    
    public void retournerDoc(int indice) {
        this.liste.get(indice).retournerDoc(); //doc.retournerDoc()
    }
    
    public void reserverDoc(int indice, MembreBibliotheque membre) {
        this.liste.get(indice).reserver(membre); //doc.resereverDoc(membre)
    }
    
    public void annulerReservation(int indice, MembreBibliotheque membre) {
        this.liste.get(indice).annulerReservation(membre); //doc.annulerReservation(membre)
    }
    
    public String toString(int indice) { //toString d'un document connu par son indice
        if (indice > 0 && indice <= this.dernier) {
            return "Document n°" + indice + " :\n" + this.liste.get(indice).toString();
        }
        return null;
    }
    
    @Override
    public String toString() { //toString minimum sur une ligne pour tous les documents
        String chaine = "";
        //for (int i = 1; i <= this.dernier; i++) {
        for (DocBibliotheque doc : this.liste) {
            int i = 1;
            chaine += "Document n°" + i++ + " : " + doc.toString() + "\n";
        }
        return chaine;
    }
}
