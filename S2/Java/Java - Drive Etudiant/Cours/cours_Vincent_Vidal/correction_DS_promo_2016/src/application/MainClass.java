package application;

import metier.*;
import java.util.*;

public class MainClass {
    
    public static void main(int argc, String[] argv)
    {
        
        Poulet acrobatique = new Poulet(2000);
        
        Canard vc = new Canard(120);
        
        Poulet paprika = new Poulet(0.8F);
        
        Canard laque = new Canard(0.3F);
        
        Elevage poulailler = new Elevage(new ArrayList<Volaille>(), 4);
        
        poulailler.afficherCanard();
        
        poulailler.afficherPoulet();
        
        for(Volaille v : poulailler.envoyerALAbattoir())
        {
            
            System.out.println(v.toString());
            
        }
        
        Poulet fris = new Poulet(1337);
        
        try
        {
        
            poulailler.ajouter(fris);
            
            poulailler.rechercherVolailleParId(3);
        
        }
        catch (VolailleExistante e)
        {
            
            System.out.println(e.getMessage());
            
        }
        catch (VolailleInexistante e)
        {
            
            System.out.println(e.getMessage());
            
        }
        catch (Exception e)
        {
            
            System.out.println("Unhandled exception: " + e.getMessage());
            
        }
        
        
    }
    
}