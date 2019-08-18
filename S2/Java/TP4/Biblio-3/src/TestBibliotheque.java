import java.util.Scanner;

public class TestBibliotheque {
 
    public static void main(String[] Args) {
        
        //MembreBibliotheque membre_1 = new MembreBibliotheque ("Gaillard", "Michel", "0749274938", "3 rue des Fleures");
        //MembreBibliotheque membre_2 = new MembreBibliotheque ("Bertrand", "Jack", "0721587469", "7 allée des Champs");
        
        DocBibliotheque doc_1 = new DocBibliotheque ("ZER-128", "Jeau-Marc au pays des lapins", "Paul Berger", 2014);
        //DocBibliotheque doc_2 = new DocBibliotheque ("GDF-654", "Deux hommes sur la lune", "Valentin Giraud", 1978);
        
        
        int nombre = 0;
        Scanner entree = new Scanner(System.in);
        while (nombre != 10) {
            afficher();
            System.out.println("Entrer votre choix : ");
            String ligne = entree.nextLine();
            nombre = gestionErreur(ligne);
            
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
                    String etat = entree.nextLine();
                    switch(gestionErreur(etat)) {
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
    
    public static int gestionErreur(String nb)
    {
        switch(nb)
        {
            case "1":
                return 1;
                
            case "2":
                return 2;
                
            case "3":
                return 3;
                
            case "4":
                return 4;
                
            case "5":
                return 5;
                
            case "6":
                return 6;
                
            case "7":
                return 7;
                
            case "8":
                return 8;
                
            case "9":
                return 9;
            
            case "10":
                return 10;
                
            default :
                return 0;
        }
        //Fin switch
    }
    //Fin gestionErreur()
}
//Fin main()