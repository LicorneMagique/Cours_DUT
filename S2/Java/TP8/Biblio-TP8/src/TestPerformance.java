import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class TestPerformance {

    public static void main(String[] args) {
            
        int nb = 10000;

        //création d'in grand nombre d'objects DocBibliotheque
        DocBibliotheque[] tableau = new DocBibliotheque[nb];
        for (int i = 0; i < nb; i++) {
            tableau[i] = new DocBibliotheque("004. 178 K20PM", "Introduction à Java", "J. Leblanc", 2015);
        }
        
        ArrayList<DocBibliotheque> array = new ArrayList<>();
        LinkedList<DocBibliotheque> linked = new LinkedList<>();
        HashSet<DocBibliotheque> bash = new HashSet<>();
        
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < nb; i++) {
            array.add(tableau[i]);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Insertion array : " + (endTime - startTime) + " ms");
        
        startTime = System.currentTimeMillis();
        for (int i = 0; i < nb; i++) {
            linked.add(tableau[i]);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Insertion linked : " + (endTime - startTime) + " ms");
        
        startTime = System.currentTimeMillis();
        for (int i = 0; i < nb; i++) {
            bash.add(tableau[i]);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Insertion bash : " + (endTime - startTime) + " ms");
        
    }

}


/*
import java.util.ArrayList;
import java.util.;
import java.util.ArrayList;


public class TestPerformance {
    
    public static void main(String[] args) {
        
        ArrayList <DocBibliotheque> tableau = new ArrayList<>();
        
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            tableau.add(new DocBibliotheque("004. 178 K20PM", "Introduction à Java", "J. Leblanc", 2015));
        }
        long endTime = System.currentTimeMillis();
        
        System.out.println("Execution : " + (endTime - startTime));
    }
    
}
*/

