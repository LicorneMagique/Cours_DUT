public class impot {
    public static double impot (double revenu) {
        if (revenu < 20000) {
            return 0.05*revenu;
        }
        else if (revenu < 40000) {
            return 1000+0.1*(revenu-20000);
        }
        else if (revenu < 60000) {
            return 3000+0.15*(revenu-40000);
        }
        else {
            return 6000+0.3*(revenu-60000);
        }
    }
    
        public static void main(String[] args) {
        System.out.print("impot : ");
        System.out.println(impot(57000));
    }
}