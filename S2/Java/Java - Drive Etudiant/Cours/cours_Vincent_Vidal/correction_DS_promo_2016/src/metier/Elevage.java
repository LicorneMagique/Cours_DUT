
package metier;

import java.util.*;

public class Elevage {
    private ArrayList<Volaille> lesVolailles;
    public int nbVolailles;

    public Elevage(ArrayList<Volaille> lesVolailles, int nbVolailles) {
        this.lesVolailles = lesVolailles;
        this.nbVolailles = nbVolailles;
    }
    
    public void ajouter(Volaille v) throws VolailleExistante{
        for (Volaille vo : this.lesVolailles){
            if (vo.getNumId() == v.getNumId()){
                throw new VolailleExistante();
            }
        }        
        lesVolailles.add(v);
    }
    
    public Volaille rechercherVolailleParId(int id) throws VolailleInexistante{
        for (Volaille v: this.lesVolailles){
            if(v.getNumId() == v.getNumId()){
                return v;
            }
        }
        throw new VolailleInexistante();
    }
    public double evaluerElevage(){
        double somme=0;
        for (Volaille v: this.lesVolailles){
            if (v.assezGrosse()){
                somme+=v.prix();
            }
        }
        return somme;
    }
    
    public List<Volaille> envoyerALAbattoir(){
        ArrayList<Volaille> liste = new ArrayList<>();
        for (Volaille v: this.lesVolailles){
            if (v.assezGrosse()){
                liste.add(v);
                this.lesVolailles.remove(v);
            }
        }
    return liste;
    }

    @Override
    public String toString() {
        StringBuilder informations = new StringBuilder();
        for (Volaille v: this.lesVolailles){
            informations.append("Type:\n").append(v.getClass());
        }
        return informations.toString();
    }
    
    public void afficherPoulet(){
        for (Volaille v: this.lesVolailles){
            if (v.getClass()== Poulet.class){
                System.out.println(v.toString());
               
            }
        }
    }
    
    public void afficherCanard(){
        for (Volaille v: this.lesVolailles){
            if (v.getClass()==Canard.class){
                System.out.println(v.toString());
               }
        }
    }
}

