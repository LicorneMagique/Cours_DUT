import java.util.ArrayList;

public class CatalogueBibliotheque {
    ArrayList<DocBibliotheque> catalogue;
    private int indice = 0;
    
    public CatalogueBibliotheque() {
         this.catalogue = new ArrayList<>();
    }
    
    public int getIndice() {
        return this.indice;
    }
    
    public DocBibliotheque getDoc(int indice_Doc_to_get) {
        if (indice_Doc_to_get >= 0 && indice_Doc_to_get < indice) {
            return this.catalogue.get(indice_Doc_to_get);
        }
        System.out.println("Erreur d'indice");
        return null;
    }
    
    public void ajouterDoc(DocBibliotheque newDoc) {
        if (newDoc != null) {
            this.catalogue.add(this.indice++, newDoc);
        }

    }
    
    public void enleverDoc(int indice_to_remove) {
        this.catalogue.remove(indice_to_remove);
        this.indice--;
    }
    
}