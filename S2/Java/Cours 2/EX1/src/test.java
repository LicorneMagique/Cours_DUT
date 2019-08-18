public class test {
    public static void main(String[] args) {
        BienImmobilier maison1 = new BienImmobilier();
        System.out.println(maison1.toString() + "\n");
        
        BienImmobilier maison2 = new BienImmobilier();
        System.out.println(maison2.toString() + "\n");
        
        BienImmobilier maison3 = new BienImmobilier();
        System.out.println(maison3.toString() + "\n");
        
        BienImmobilier maison4 = new BienImmobilier();
        System.out.println(maison4.toString() + "\n");
        
        maison1.setVente(-27.9298, "Antoine Daniel");
        maison1.setVente(2792.98, "Antoine Daniel");
        System.out.println(maison1.toString() + "\n");
        
        maison1.setLocation("Michel");
        System.out.println(maison1.toString() + "\n");
        
        maison1.setFinLocation();
        System.out.println(maison1.toString() + "\n");
    }
}