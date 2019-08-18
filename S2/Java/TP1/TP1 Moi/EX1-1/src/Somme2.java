public class Somme2 {

    public static void main(String[] args) {
        calculSomme();
    }
    
    public static void calculSomme() {
        int Somme = 0;
        for (int i = 1; i <= 100; i++)
        Somme = Somme + i;
        System.out.println(Somme);
    }
}