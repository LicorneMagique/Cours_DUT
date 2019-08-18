package metier;

// classe mères = abstract
// static : propre à la classe, ici un id est tjrs propre à la classe
public abstract class Volaille {
    private float poids;
    private int numId;
    private static int dernierNumId = 1;

    public Volaille(float poids) {
        this.poids = poids;
        this.numId = dernierNumId;
        dernierNumId++;
    }

    public float getPoids() {
        return poids;
    }

    public int getNumId() {
        return numId;
    }

    public static int getDernierNumId() {
        return dernierNumId;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    public static void setDernierNumId(int dernierNumId) {
        Volaille.dernierNumId = dernierNumId;
    }
    
    public abstract boolean assezGrosse();
    public abstract double prix();

    @Override
    public String toString() {
        return "Volaille{" + "poids=" + poids + ", numId=" + numId + '}';
    }
    
}

