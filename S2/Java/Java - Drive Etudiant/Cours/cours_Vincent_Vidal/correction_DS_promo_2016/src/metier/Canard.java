
package metier;

public class Canard extends Volaille{
    private float prix = 1.2F;
    private float poidAbattage = 1.5F;
    
    public Canard(float poids) {
        super(poids);
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setPoidAbattage(float poidAbattage) {
        this.poidAbattage = poidAbattage;
    }

    @Override
     public boolean assezGrosse() {
         if (this.getPoids()>this.poidAbattage){
             return true;
         }
         return false;
        }

    @Override
    public double prix() {
        return this.getPoids()*prix;
    }

    @Override
    public String toString() {
        return "Canard{" + "prix=" + prix + ", poidAbattage=" + poidAbattage + '}';
    }
    
    
}
