package bibliotheque;

import java.util.Scanner;

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
        
        boolean menu = true;
        Scanner entree = new Scanner(System.in);
        Scanner entree2 = new Scanner(System.in);
        int choix, choix2;
        String pause;
        
        while (menu) {
            affichageMenu();
            choix = entree.nextInt();
            
            switch(choix) {
                
                case 0: //Quitter
                    menu = false;
                    break;
                
                case 1: //Afficher les informations d'un document
                    nettoyerAffichage(10);
                    System.out.print("\nChoisissez le numéro d'un document : ");
                    choix = entree.nextInt();
                    nettoyerAffichage(10);
                    if (choix == 1) System.out.println("Doc 1 : \"Introduction à Java\" de J. Leblanc");
                    else System.out.println("Doc 2 : \"Structures de Données\" de M. Machin");
                    System.out.print("\nAppuyer sur une touche pour continuer");
                    pause = entree2.nextLine();
                    nettoyerAffichage(10);
                    break;
                
                case 2: //Connaître l’état d’un document
                    nettoyerAffichage(10);
                    System.out.print("\nChoisissez le numéro d'un document : ");
                    choix = entree.nextInt();
                    nettoyerAffichage(10);
                    if (choix == 1) {
                        switch(Doc1.getEtatDoc()) {
                            case 0:
                                System.out.println("\nDoc 1 : sur les étagères");
                                break;
                            case 1:
                                System.out.println("\nDoc 1 : sur la pile des retours");
                                break;
                            case 2:
                                System.out.println("\nDoc 1 : sur la section réservations");
                                break;
                            case 3:
                                System.out.println("\nDoc 1 : emprunté");
                                break;
                        }
                    }
                    else {
                        switch(Doc2.getEtatDoc()) {
                            case 0:
                                System.out.println("\nDoc 2 : sur les étagères");
                                break;
                            case 1:
                                System.out.println("\nDoc 2 : sur la pile des retours");
                                break;
                            case 2:
                                System.out.println("\nDoc 2 : sur la section réservations");
                                break;
                            case 3:
                                System.out.println("\nDoc 2 : emprunté");
                                break;
                        }
                    }
                    System.out.print("\nAppuyer sur une touche pour continuer");
                    pause = entree2.nextLine();
                    nettoyerAffichage(10);
                    break;
                
                case 3: //Emprunter un document
                    nettoyerAffichage(10);
                    System.out.print("\nChoisissez le numéro d'un document : ");
                    choix = entree.nextInt();
                    nettoyerAffichage(10);
                    
                    nettoyerAffichage(10);
                    System.out.print("\nChoisissez le numéro d'un membre : ");
                    choix2 = entree.nextInt();
                    nettoyerAffichage(10);
                    
                    if (choix == 1) {
                        if (choix2 == 1) {
                            if (Doc1.emprunterDoc(Membre1)) {
                                System.out.println("Le membre 1 a emprunté le document 1");
                            }
                            else {
                                System.out.println("Erreur");
                            }
                        }
                        else {
                            if (Doc1.emprunterDoc(Membre2)) {
                                System.out.println("Le membre 2 a emprunté le document 1");
                            }
                            else {
                                System.out.println("Erreur");
                            }
                        }
                    }
                    else {
                        if (choix2 == 1) {
                            if (Doc1.emprunterDoc(Membre1)) {
                                System.out.println("Le membre 1 a emprunté le document 2");
                            }
                            else {
                                System.out.println("Erreur");
                            }
                        }
                        else {
                            if (Doc1.emprunterDoc(Membre2)) {
                                System.out.println("Le membre 2 a emprunté le document 2");
                            }
                            else {
                                System.out.println("Erreur");
                            }
                        }
                    }
                    System.out.print("\nAppuyer sur une touche pour continuer");
                    pause = entree2.nextLine();
                    nettoyerAffichage(10);
                    break;
                
                case 4: //Rendre un document
                    nettoyerAffichage(10);
                    System.out.print("\nChoisissez le numéro du document : ");
                    choix = entree.nextInt();
                    nettoyerAffichage(10);
                    if (choix == 1) {
                        if (Doc1.retournerDoc()) {
                            System.out.println("Le document 1 a été rendu");
                        }
                        else {
                            System.out.println("Erreur");
                        }
                    }
                    else {
                        if (Doc2.retournerDoc()) {
                            System.out.println("Le document 2 a été rendu");
                        }
                        else {
                            System.out.println("Erreur");
                        }
                    }
                    System.out.print("\nAppuyer sur une touche pour continuer");
                    pause = entree2.nextLine();
                    nettoyerAffichage(10);
                    break;
                
                case 5: //Ranger un document
                    nettoyerAffichage(10);
                    System.out.print("\nChoisissez le numéro du document : ");
                    choix = entree.nextInt();
                    nettoyerAffichage(10);
                    if (choix == 1) {
                        if (Doc1.rangerDoc()) {
                            System.out.println("Le document 1 a été rangé");
                        }
                        else {
                            System.out.println("Erreur");
                        }
                    }
                    else {
                        if (Doc2.rangerDoc()) {
                            System.out.println("Le document 2 a été rangé");
                        }
                        else {
                            System.out.println("Erreur");
                        }
                    }
                    System.out.print("\nAppuyer sur une touche pour continuer");
                    pause = entree2.nextLine();
                    nettoyerAffichage(10);
                    break;
                
                case 6: //Faire une réservation
                    nettoyerAffichage(10);
                    System.out.print("\nChoisissez le numéro du document : ");
                    choix = entree.nextInt();
                    nettoyerAffichage(10);
                    
                    nettoyerAffichage(10);
                    System.out.print("\nChoisissez le numéro du membre : ");
                    choix2 = entree.nextInt();
                    nettoyerAffichage(10);
                    
                    if (choix == 1) {
                        if (choix2 == 1) {
                            if (Doc1.reserverDoc(Membre1)) {
                                System.out.println("Le membre 1 a reservé le document 1");
                            }
                            else {
                                System.out.println("Erreur");
                            }
                        }
                        else {
                            if (Doc1.reserverDoc(Membre2)) {
                                System.out.println("Le membre 2 a reservé le document 1");
                            }
                            else {
                                System.out.println("Erreur");
                            }
                        }
                    }
                    else {
                        if (choix2 == 1) {
                            if (Doc1.reserverDoc(Membre1)) {
                                System.out.println("Le membre 1 a reservé le document 2");
                            }
                            else {
                                System.out.println("Erreur");
                            }
                        }
                        else {
                            if (Doc1.reserverDoc(Membre2)) {
                                System.out.println("Le membre 2 a reservé le document 2");
                            }
                            else {
                                System.out.println("Erreur");
                            }
                        }
                    }
                    System.out.print("\nAppuyer sur une touche pour continuer");
                    pause = entree2.nextLine();
                    nettoyerAffichage(10);
                    break;
                
                case 7: //Annuler une réservation
                    nettoyerAffichage(10);
                    System.out.print("\nChoisissez le numéro du document : ");
                    choix = entree.nextInt();
                    nettoyerAffichage(10);
                    
                    nettoyerAffichage(10);
                    System.out.print("\nChoisissez le numéro du membre : ");
                    choix2 = entree.nextInt();
                    nettoyerAffichage(10);
                    
                    if (choix == 1) {
                        if (choix2 == 1) {
                            if (Doc1.annulerReservation(Membre1)) {
                                System.out.println("Le membre 1 a annulé la réservation du "
                                        + "document 1");
                            }
                            else {
                                System.out.println("Erreur");
                            }
                        }
                        else {
                            if (Doc1.annulerReservation(Membre2)) {
                                System.out.println("Le membre 2 a annulé la réservation du "
                                        + "document 1");
                            }
                            else {
                                System.out.println("Erreur");
                            }
                        }
                    }
                    else {
                        if (choix2 == 1) {
                            if (Doc1.annulerReservation(Membre1)) {
                                System.out.println("Le membre 1 a annulé la réservation du "
                                        + "document 2");
                            }
                            else {
                                System.out.println("Erreur");
                            }
                        }
                        else {
                            if (Doc1.annulerReservation(Membre2)) {
                                System.out.println("Le membre 2 a annulé la réservation du "
                                        + "document 2");
                            }
                            else {
                                System.out.println("Erreur");
                            }
                        }
                    }
                    System.out.print("\nAppuyer sur une touche pour continuer");
                    pause = entree2.nextLine();
                    nettoyerAffichage(10);
                    break;
                
                case 8: //Afficher le nombre de documents empruntés
                    nettoyerAffichage(10);
                    System.out.println("Il y a " + DocBibliotheque.getNbDocEmprunte()
                            + " documents empruntés");
                    
                    System.out.print("\nAppuyer sur une touche pour continuer");
                    pause = entree2.nextLine();
                    nettoyerAffichage(10);
                    break;
                
                case 9: //Afficher le nombre de documents sur la pile des retours
                    nettoyerAffichage(10);
                    System.out.println("Il y a " + DocBibliotheque.getNbDocPile()
                            + " documents sur la pile des retours");
                    
                    System.out.print("\nAppuyer sur une touche pour continuer");
                    pause = entree2.nextLine();
                    nettoyerAffichage(10);
                    break;
                
                case 10: //Afficher le nombre de documents dans la section spéciale réservations
                    nettoyerAffichage(10);
                    System.out.println("Il y a " + DocBibliotheque.getNbDocSectionReservation()
                            + " documents sur la section réservation");
                    
                    System.out.print("\nAppuyer sur une touche pour continuer");
                    pause = entree2.nextLine();
                    nettoyerAffichage(10);
                    break;
                
            } //fin du switch
            
        } //fin du while
        
    } //fin du main
    
    public static void affichageMenu() {
        nettoyerAffichage(10);
        System.out.println(
                  "1  : Afficher les informations d'un document\n"
                + "2  : Connaître l’état d’un document\n"
                + "3  : Emprunter un document\n"
                + "4  : Rendre un document\n"
                + "5  : Ranger un document\n"
                + "6  : Faire une réservation\n"
                + "7  : Annuler une réservation\n"
                + "8  : Afficher le nombre de documents empruntés\n"
                + "9  : Afficher le nombre de documents sur la pile des retours\n"
                + "10 : Afficher le nombre de documents dans la section réservations\n"
                + "\n0  : Quitter\n");
        System.out.print("Entrer votre choix : ");
    }
    
    public static void nettoyerAffichage(int lignes) {
        for (int i = 0; i < lignes; i++) System.out.println("\n");
    }
    
}
