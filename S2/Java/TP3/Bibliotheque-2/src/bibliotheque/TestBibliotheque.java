package bibliotheque;

public class TestBibliotheque {
    
    public static void main(String[] args) {
        
        //créer des documents
        DocBibliotheque Doc1 = new DocBibliotheque("004. 178 K20PM",
                "Introduction à Java", "J. Leblanc", 2015);
        DocBibliotheque Doc2 = new DocBibliotheque("967. 4987 T248O",
                "Structures de Données", "M. Machin", 2017);
        
        //créer des membres
        MembreBibliotheque Membre1 = new MembreBibliotheque("Bernard", "Alfred",
                "06 74 38 27 49", "6 rue des Fleures");
        MembreBibliotheque Membre2 = new MembreBibliotheque("Lambert", "Paul",
                "07 41 68 75 78", "6 rue des Fleures");
        
        //obtenir les informations relatives à ces documents
        System.out.println("Doc1 :\n" + Doc1.toString() + "\n");
        
        
        //faire emprunter puis louer un doc
        Doc2.emprunterDoc(Membre1);
        Doc2.reserverDoc(Membre2);
        System.out.println("Doc2 :\n" + Doc2.toString() + "\n");

    }
    
}
