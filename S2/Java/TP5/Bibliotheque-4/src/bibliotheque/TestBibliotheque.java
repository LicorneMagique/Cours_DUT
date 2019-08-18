package bibliotheque;

import java.util.Scanner;

public class TestBibliotheque {
    
    public static void main(String[] args) {
        
        //créer un catalogue de documents
        CatalogueBibliotheque catalogue = new CatalogueBibliotheque(); //création du catalogue
        catalogue.ajouterDoc(new DocBibliotheque("004. 178 K20PM",
                "Introduction à Java", "J. Leblanc", 2015)); //ajout de Doc1 au catalogue
        catalogue.ajouterDoc(new DocBibliotheque("967. 4987 T248O",
                "Structures de Données", "M. Machin", 2017)); //ajout de Doc2 au catalogue
        
        //créer une liste de membres
        ListeMembres membres = new ListeMembres(); //création de la liste
        membres.ajouterMembre(new MembreBibliotheque("Bernard", "Alfred",
                "06 74 38 27 49", "6 rue des Fleures")); //ajout de Membre1
        membres.ajouterMembre(new MembreBibliotheque("Lambert", "Paul",
                "07 41 68 75 78", "6 rue des Fleures")); //ajout de Membre2
        
        boolean menu = true;
        Scanner entree = new Scanner(System.in);
        Scanner entree2 = new Scanner(System.in);
        int choix;
        
        MembreBibliotheque membre;
        DocBibliotheque doc;
        
        String nom, prenom, tel, adresse, code, titre, auteur, newTxt;
        int annee;
        while (menu) {
            affichageMenu();
            choix = entree.nextInt();
            
            switch(choix) {
                
                case 0: //Quitter
                    menu = false;
                    break;
                    
                case 1: //Ajouter un nouveau membre
                    nettoyerAffichage();
                    
                    System.out.print("\nEntrer le nom du nouveau membre : ");
                    nom = entree2.nextLine();
                    nettoyerAffichage();
                    
                    System.out.print("\nEntrer le prénom du nouveau membre : ");
                    prenom = entree2.nextLine();
                    nettoyerAffichage();
                    
                    System.out.print("\nEntrer le numéro de téléphone du nouveau membre : ");
                    tel = entree2.nextLine();
                    nettoyerAffichage();
                    
                    System.out.print("\nEntrer l'adresse du nouveau membre : ");
                    adresse = entree2.nextLine();
                    nettoyerAffichage();
                    
                    if (membres.ajouterMembre(new MembreBibliotheque(nom, prenom, tel, adresse))) {
                        System.out.println("Membre ajouté");
                    }
                    else {
                        System.out.println("Erreur de saisi");
                    }
                    
                    finCase(entree2);
                    break;
                    
                case 2: //Afficher les informations d'un membre
                    membre = selectMembre(membres);
                    
                    if (membre != null) { //s'il n'y a pas eu d'erreur
                        System.out.println(membre.toString());
                    }
                    
                    finCase(entree2);
                    break;
                    
                case 3: //Modifier les informations d'un membre
                    membre = selectMembre(membres);
                    
                    if (membre != null) { //s'il n'y a pas eu d'erreur
                        System.out.println("1 : Modifier le nom du membre\n"
                            + "2 : Modifier le prénom du membre\n"
                            + "3 : Modifier le numéro de téléphone du membre\n"
                            + "4 : Modifier l'adresse du membre\n");
                    
                        System.out.print("\nChoisissez l'élément que vous souhaitez modifier : ");
                        choix = entree.nextInt();

                        nettoyerAffichage();
                        
                        if (choix > 0 && choix <= 4) { //s'il n'y a pas eu d'erreur
                        
                            System.out.print("\nChoisissez sa nouvelle valeur : ");
                            newTxt = entree2.nextLine();

                            nettoyerAffichage();

                            switch(choix) {
                                    
                                case 1:
                                    if (membre.setNom(newTxt)) {
                                        System.out.println("Le nom du membre a bien été changé");
                                    }
                                    else {
                                        System.out.println("Erreur de saisi");
                                    }
                                    break;

                                case 2:
                                    if (membre.setPrenom(newTxt)) {
                                        System.out.println("Le prénom du membre a bien été changé");
                                    }
                                    else {
                                        System.out.println("Erreur de saisi");
                                    }
                                    break;

                                case 3:
                                    if (membre.setTel(newTxt)) {
                                        System.out.println("Le numéro de téléphone du membre a bien été changé");
                                    }
                                    else {
                                        System.out.println("Erreur de saisi");
                                    }
                                    break;

                                case 4:
                                    if (membre.setAdresse(newTxt)) {
                                        System.out.println("L'adresse du membre a bien été changé");
                                    }
                                    else {
                                        System.out.println("Erreur de saisi");
                                    }
                                    break;

                                default :
                                    System.out.print("Erreur de saisi");
                                    break;
                            } //fin switch
                            
                        } //fin if (choix == OK)
                        else {
                                System.out.println("Erreur de saisi");
                            }
                    } //fin if (membre != null)
                    
                    finCase(entree2);
                    break;
                    
                case 4: //Ajouter un nouveau document
                    nettoyerAffichage();
                    
                    System.out.print("\nEntrer le code du nouveau document : ");
                    code = entree2.nextLine();
                    nettoyerAffichage();
                    
                    System.out.print("\nEntrer le titre du nouveau document : ");
                    titre = entree2.nextLine();
                    nettoyerAffichage();
                    
                    System.out.print("\nEntrer l'auteur du nouveau document : ");
                    auteur = entree2.nextLine();
                    nettoyerAffichage();
                    
                    System.out.print("\nEntrer l'année de publication du nouveau document : ");
                    annee = entree.nextInt();
                    nettoyerAffichage();
                    
                    if (catalogue.ajouterDoc(new DocBibliotheque(code, titre, auteur, annee))) {
                        System.out.println("Document ajouté");
                    }
                    else {
                        System.out.println("Erreur de saisi");
                    }
                    
                    finCase(entree2);
                    break;
                    
                case 5: //Supprimer un document
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        if (catalogue.enleverDoc(doc)) {
                            System.out.println("Document supprimé");
                        }
                        else {
                            System.out.println("Erreur de saisi");
                        }
                    }
                    finCase(entree2);
                    break;
                
                case 6: //Afficher les informations d'un document
                    doc = selectDoc(catalogue);
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        System.out.println(doc.toString());
                    }
                    
                    finCase(entree2);
                    break;
                    
                case 7: //Modifier les informations d'un document
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        System.out.println("1 : Modifier le code du document\n"
                            + "2 : Modifier le titre du document\n"
                            + "3 : Modifier l'auteur du document\n"
                            + "4 : Modifier l'année de publication du document\n");

                        System.out.print("\nChoisissez l'élément que vous souhaitez modifier : ");
                        choix = entree.nextInt();
                        nettoyerAffichage();

                        if (choix == 4) { //seul cas où l'entrée est un int
                                System.out.print("Entrer la nouvelle année de publication du document : ");
                                    annee = entree.nextInt();
                                    nettoyerAffichage();
                                    
                                    if (annee != 0) { //s'il n'y a pas eu d'erreur
                                        doc.setAnnee(annee);
                                        System.out.println("Année modifiée");
                                    }
                                    else {
                                        System.out.println("Erreur de saisi");
                                    }
                                    break;
                            }
                            else {
                                System.out.print("Entrer la nouvelle valeur de cet élément : ");
                                newTxt = entree2.nextLine();
                                nettoyerAffichage();
                                
                                switch(choix) {
                                        
                                    case 1:
                                        if (doc.setCode(newTxt)) {
                                            System.out.println("Code modifié");
                                        }
                                        else {
                                            System.out.println("Erreur de saisi");
                                        }
                                        break;

                                    case 2:
                                        if (doc.setTitre(newTxt)) {
                                            System.out.println("Titre modifié");
                                        }
                                        else {
                                            System.out.println("Erreur de saisi");
                                        }
                                        break;

                                    case 3:
                                        if (doc.setAuteur(newTxt)) {
                                            System.out.println("Auteur modifié");
                                        }
                                        else {
                                            System.out.println("Erreur de saisi");
                                        }
                                        break;

                                    default:
                                        System.out.println("Erreur de saisi");
                                } //fin switch
                                
                            } //fin else
                        
                    } //fin if (doc != null)
                    
                    finCase(entree2);
                    break;
                
                case 8: //Afficher l’état d’un document
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        System.out.print("Le document est ");
                        
                        switch(doc.getEtatDoc()) {
                            
                            case 0:
                                System.out.println("sur les étagères.");
                                break;

                            case 1:
                                System.out.println("sur la pile des retours.");
                                break;

                            case 2:
                                System.out.println("sur la section réservations.");
                                break;

                            case 3:
                                System.out.println("emprunté.");
                                break;
                        }
                    }
                    
                    finCase(entree2);
                    break;
                
                case 9: //Emprunter un document
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        membre = selectMembre(membres);
                        
                        if (membre != null) { //s'il n'y a pas eu d'erreur
                            if (doc.emprunterDoc(membre)) {
                                System.out.println("Le document est maintenant emprunté");
                            }
                            else {
                                System.out.println("Opération impossible");
                            }
                        }
                    }
                    
                    finCase(entree2);
                    break;
                
                case 10: //Rendre un document
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        if (doc.retournerDoc()) {
                            System.out.println("Document rendu");
                        }
                        else {
                            System.out.println("Opération impossible");
                        }
                    }
                    
                    finCase(entree2);
                    break;
                
                case 11: //Ranger un document
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        if (doc.rangerDoc()) {
                            System.out.println("Document rangé");
                        }
                        else {
                            System.out.println("Opération impossible");
                        }
                    }
                    
                    finCase(entree2);
                    break;
                
                case 12: //Faire une réservation
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        membre = selectMembre(membres);
                        
                        if (membre != null) { //s'il n'y a pas eu d'erreur
                            if (doc.reserverDoc(membre)) {
                                System.out.println("Le document est maintenant réservé");
                            }
                            else {
                                System.out.println("Opération impossible");
                            }
                        }
                    }
                    
                    finCase(entree2);
                    break;
                
                case 13: //Annuler une réservation
                    doc = selectDoc(catalogue);
                    
                    if (doc != null) { //s'il n'y a pas eu d'erreur
                        membre = selectMembre(membres);
                        
                        if (membre != null) { //s'il n'y a pas eu d'erreur
                            if (doc.annulerReservation(membre)) {
                                System.out.println("La réservation du document est annulée");
                            }
                            else {
                                System.out.println("Opération impossible");
                            }
                        }
                    }
                    
                    finCase(entree2);
                    break;
                
                case 14: //Afficher le nombre de documents empruntés
                    nettoyerAffichage();
                    System.out.println("Il y a " + DocBibliotheque.getNbDocEmprunte()
                            + " document(s) emprunté(s)");
                    
                    finCase(entree2);
                    break;
                
                case 15: //Afficher le nombre de documents sur la pile des retours
                    nettoyerAffichage();
                    System.out.println("Il y a " + DocBibliotheque.getNbDocPile()
                            + " document(s) sur la pile des retours");
                    
                    finCase(entree2);
                    break;
                
                case 16: //Afficher le nombre de documents dans la section spéciale réservations
                    nettoyerAffichage();
                    System.out.println("Il y a " + DocBibliotheque.getNbDocSectionReservation()
                            + " document(s) sur la section réservation");
                    
                    finCase(entree2);
                    break;
                    
                default :
                    System.out.println("Erreur de saisi");
                    break;
                
            } //fin du switch
            
        } //fin du while
        

        
    } //fin du main
    
    public static void affichageMenu() {
        nettoyerAffichage();
        System.out.println(
                  "1  : Ajouter un nouveau membre\n"
                + "2  : Afficher les informations d'un membre\n"
                + "3  : Modifier les informations d'un membre\n"
                + "4  : Ajouter un nouveau document\n"
                + "5  : Supprimer un document\n"
                + "6  : Afficher les informations d'un document\n"
                + "7  : Modifier les informations d'un document\n"
                + "8  : Afficher l’état d’un document\n"
                + "9  : Emprunter un document\n"
                + "10 : Rendre un document\n"
                + "11 : Ranger un document\n"
                + "12 : Faire une réservation\n"
                + "13 : Annuler une réservation\n"
                + "14 : Afficher le nombre de documents empruntés\n"
                + "15 : Afficher le nombre de documents sur la pile des retours\n"
                + "16 : Afficher le nombre de documents dans la section réservations\n"
                + "\n0  : Quitter\n");
        System.out.print("Entrer votre choix : ");
    }
    
    private static void finCase(Scanner entree2) {
        System.out.print("\nAppuyer sur une touche pour continuer");
        String pause;
        pause = entree2.nextLine();
        pause += "";
        nettoyerAffichage();
    }
    
    private static DocBibliotheque selectDoc(CatalogueBibliotheque catalogue) {
        int choix;
        Scanner entree = new Scanner(System.in);
        
        nettoyerAffichage();
                    
        //affichage de la liste des documents
        System.out.println(catalogue.toString());

        System.out.print("\nChoisissez le numéro d'un document : ");
        choix = entree.nextInt();
        nettoyerAffichage();

        if (choix > 0 && choix <= catalogue.getDernier()) {
            return catalogue.getDoc(choix);
        }
        else {
            System.out.println("Erreur de saisi");
            return null;
        }
    }
    
    private static MembreBibliotheque selectMembre(ListeMembres membres) {
        int choix;
        Scanner entree = new Scanner(System.in);
        
        nettoyerAffichage();
                    
        //affichage de la liste des membres
        System.out.println(membres.toString());

        System.out.print("\nChoisissez le numéro d'abonné d'un membre : ");
        choix = entree.nextInt();
        nettoyerAffichage();

        if (choix > 0 && choix <= membres.getDernier()) { //si le membre existe
            return membres.liste.get(choix);
        }
        else {
            System.out.println("Erreur de saisi");
            return null;
        }
    }
    
    private static void nettoyerAffichage() {
        for (int i = 0; i < 20; i++) System.out.println("\n");
    }
    
}
