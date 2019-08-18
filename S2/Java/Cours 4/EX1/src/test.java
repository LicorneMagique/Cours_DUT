import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Proprietaire Jean = new Proprietaire("Jean Renaud", "6 rue des Lapins", 45.3, 76.1);
        Proprietaire Roger = new Proprietaire("Roger Albert", "9 rue du Centre", 820.76, 102.25);
        Locataire Michel = new Locataire("Michel Baron", "4 allee des Fleures", 549.7, 76.1);
        
        BienImmobilier maison1 = new BienImmobilier(Jean);
        maison1.setLocation(Michel);
        
        BienImmobilier maison2 = new BienImmobilier(Roger);
        maison2.setVente(77659.43);
        
        int nombre = 0;
        while (nombre != 10)
        {
            afficher();
            Scanner entree = new Scanner(System.in);
            System.out.print("Entrer votre choix : ");
            String ligne = entree.nextLine();
            nombre = gestionErreur(ligne);
            
            switch(nombre)
            {
                case 10:
                    //On quitte le menu
                    break;
                    
                case 1:
                    //Afficher infos propriétaire
                    System.out.println(Jean.toString() + "\n");
                    System.out.println(Roger.toString() + "\n");
                    break;
                    
                case 2:
                    //Afficher infos locataire
                    System.out.println(Michel.toString() + "\n");
                    break;
                    
                case 3:
                    //Afficher infos bien immobilier
                    System.out.println(maison1.toString() + "\n");
                    System.out.println(maison2.toString() + "\n");
                    break;
                    
                case 4:
                    //Afficher état bien immobilier
                    System.out.println("maison1 vente :" + maison1.getVente());
                    System.out.println("maison1 location :" + maison1.getLocation() + "\n");
                    System.out.println("maison2 vente :" + maison2.getVente());
                    System.out.println("maison2 location :" + maison2.getLocation() + "\n");
                    break;
            }
        }
    }

    public static void afficher() {
        System.out.println("\n");
        System.out.println("1 : Afficher infos propriétaire");
        System.out.println("2 : Afficher infos locataire");
        System.out.println("3 : Afficher infos bien immobilier");
        System.out.println("4 : Afficher état bien immobilier");
        System.out.println("10 : Quitter");
        System.out.println("\n");
    }
    
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
    }
}