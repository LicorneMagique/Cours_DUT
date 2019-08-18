package sortieminibus.metier;

public class MiniBus {
    private int nominibus = 0;
    private int capacite = 0;
    
    public MiniBus(int newNominibus, int newCapacite) {
        this.nominibus = newNominibus;
        this.capacite = newCapacite;
    }
    
    public int getCapacite() {
        return this.capacite;
    }
    
    public int getNominibus() {
        return this.nominibus;
    }
    
    @Override
    public String toString() {
        return "Numéro du minibus : " + this.getNominibus() + "\nCapacité du minibus : " + this.getCapacite();
    }
}
