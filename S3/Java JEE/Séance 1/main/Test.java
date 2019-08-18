import classes.Proprietaire;
import classes.Restaurant;

public class Test {

    public static void main(String[] args) {
        
        Proprietaire prop = new Proprietaire("Michel", "Berro", "3 rue des Fleures", 1834.17);
        Restaurant resto = new Restaurant("Bon resto", "5 Avenue Lambert", 42, "Japonais", prop);
        System.out.println(resto.toString());
    }
}
