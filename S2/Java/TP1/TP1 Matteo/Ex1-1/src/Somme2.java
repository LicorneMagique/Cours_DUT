public class Somme2 
{
    public static int calculSomme() 
    {
        int Somme = 0;
        for (int i = 1; i <= 100; i++)
            Somme = Somme + i;
        return Somme;
    }

    public static void main(String[] args) 
    {
        System.out.println(calculSomme());
    }
}

