import java.util.Scanner;

public class TestBibliotheque {
 
    public static void main(String[] Args) {
        
        //MembreBibliotheque membre_1 = new MembreBibliotheque ("Gaillard",
        //        "Michel", "0749274938", "3 rue des Fleures");
        //MembreBibliotheque membre_2 = new MembreBibliotheque ("Bertrand",
        //        "Jack", "0721587469", "7 allée des Champs");
        //System.out.println(membre_1.getNumAbonne());
        //System.out.println(membre_2.getNumAbonne());
        
        //ListeMembres mesMembres = new ListeMembres();
        //mesMembres.ajouterMembre(membre_2);
        //mesMembres.ajouterMembre(membre_1);
        //System.out.println(mesMembres.getMembre(-1).toString());
        
        Livre doc_1 = new Livre ("ZER-128", "Jeau-Marc au pays des lapins",
                "Paul Berger", 2014, "Flame Kuche", 32, "0012");
        //Livre doc_2 = new Livre ("GDF-654", "Deux hommes sur la lune",
        //        "Valentin Giraud", 1978, "Licorne Magique", 18, "0145");
        
        //System.out.println(doc_1.toString() + "\n");
        //System.out.println(doc_2.toString() + "\n");
        
        //CatalogueBibliotheque monCatalogue = new CatalogueBibliotheque();
        //monCatalogue.ajouterDoc(doc_1);
        //monCatalogue.ajouterDoc(doc_2);
        //System.out.println(monCatalogue.getDoc(0).toString());
        
        
        int nombre = 0;
        Scanner entree = new Scanner(System.in);
        while (nombre != 10) {
            afficher();
            System.out.println("Entrer votre choix : ");
            
            //try {
                nombre = entree.nextInt();
            //}
            //catch (NombreHorsLimiteException probleme) {
            //    System.out.println("Erreur : " + probleme);
            //}
            
            switch(nombre)
            {
                case 10:
                    //On quitte le menu
                    break;
                    
                case 1:
                    //Afficher des informations sur un document
                    System.out.println(doc_1.toString());
                    System.out.println("\nAppuyer sur une touche pour quitter");
                    entree.nextLine();
                    break;
                    
                case 2:
                    //Connaître l’état d’un document
                    System.out.println(doc_1.getEtatPhysique());
                    System.out.println("\nAppuyer sur une touche pour quitter");
                    entree.nextLine();
                    break;
                    
                case 3:
                    //Changer l’état d’un document
                    int etat = entree.nextInt();
                    switch(etat) {
                        case 1:
                            
                    }
                    break;
                    
                case 4:
                    //Faire une réservation
                    break;
                
                case 5:
                    //Annuler une réservation
                    break;
                
                case 6:
                    //Afficher le nombre de documents empruntés
                    break;
                case 7:
                    //Afficher le nombre de documents sur la pile des retours
                    break;
                case 8:
                    //Afficher le nombre de documents dans la section spéciale réservations
                    break;
            }
            //Fin switch
        }
        //Fin while
        
    }

    public static void afficher() {
        //On vide l'écran :
        int i;
        for (i=0; i<100; i++) System.out.println("\n");
        System.out.println("1  : Afficher des informations sur un document");
        System.out.println("2  : Connaître l’état d’un document");
        System.out.println("3  : Changer l’état d’un document");
        System.out.println("4  : Faire une réservation");
        System.out.println("5  : Annuler une réservation");
        System.out.println("6  : Afficher le nombre de documents empruntés");
        System.out.println("7  : Afficher le nombre de documents sur la pile des retours");
        System.out.println("8  : Afficher le nombre de documents dans la section spéciale réservations");
        System.out.println("10 : Quitter");
        System.out.println("\n");
    }
    //Fin afficher()
}
//Fin main()