public class conversion {
    public static void test (char c) {
        if (c >= 'a' && c<='z') {
            int nb = (int)c;
            nb += 26;
            System.out.println("Le caractère majuscule correspondant à " + c + " est " + (char)(c-32));
        }
        else if (c >= 'A' && c <= 'Z') {
            System.out.println("Le caractère minuscule correspondant à " + c + " est " + (char)(c+32));
        }
        else {
            System.out.println(c + " n’est pas une lettre");
        }
    }
    
        public static void main(String[] args) {
        test('B');
    }
}
