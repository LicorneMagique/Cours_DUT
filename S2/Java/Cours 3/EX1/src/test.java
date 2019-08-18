public class test {
    public static void main(String[] args) {
        Proprietaire Jean = new Proprietaire("Jean Renaud", "6 rue des Lapins", 45.3, 76.1);
        Proprietaire Roger = new Proprietaire("Roger Albert", "9 rue du Centre", 820.76, 102.25);
        Locataire Michel = new Locataire("Michel Baron", "4 allee des Fleures", 549.7, 76.1);
        
        BienImmobilier maison1 = new BienImmobilier(Jean);
        maison1.setLocation(Michel);
        
        BienImmobilier maison2 = new BienImmobilier(Roger);
        maison2.setVente(77659.43);
        
        System.out.println(maison1.toString() + "\n");
        System.out.println(maison2.toString() + "\n");
    }
}