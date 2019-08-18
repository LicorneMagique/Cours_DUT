package bibliotheque;

public class TestBibliotheque {
    
    public static void main(String[] args) {
        
        //créer des documents
        DocBibliotheque Doc1 = new DocBibliotheque("004. 178 K20PM",
                "Introduction à Java", "J. Leblanc", 2015);
        DocBibliotheque Doc2 = new DocBibliotheque("967. 4987 T248O",
                "Structures de Données", "M. Machin", 2017);
        
        //obtenir les informations relatives à ces documents
        System.out.println("L'année de publication du Doc1 est : " + Doc1.getAnnee());
        System.out.println("L'auteur du Doc1 est : " + Doc1.getAuteur());
        System.out.println("Le code du Doc1 est : " + Doc1.getCode());
        System.out.println("L'état physique du Doc1 est : " + Doc1.getEtatDoc());
        System.out.println("L'état de réservation du Doc1 est : " + Doc1.getReserve());
        System.out.println("Le titre du Doc1 est : " + Doc1.getTitre());
        
        //essayer de modifier ces informations
        System.out.println("L'année de publication du Doc2 est : " + Doc2.getAnnee());
        if (!Doc2.setAnnee(0)) {
            System.out.println("Erreur avec 0");
        }
        System.out.println("L'année de publication du Doc2 est : " + Doc2.getAnnee());
        if (!Doc2.setAnnee(2017)) {
            System.out.println("Erreur avec 2017");
        }
        System.out.println("L'année de publication du Doc2 est : " + Doc2.getAnnee());
        if (!Doc2.setAnnee(1999)) {
            System.out.println("Erreur avec 1999");
        }
        System.out.println("L'année de publication du Doc2 est : " + Doc2.getAnnee());
        
        System.out.println("L'auteur du Doc2 est : " + Doc2.getAuteur());
        if (!Doc2.setAuteur(null)) {
            System.out.println("Erreur avec null");
        }
        System.out.println("L'auteur du Doc2 est : " + Doc2.getAuteur());
        if (!Doc2.setAuteur("M. Machin")) {
            System.out.println("Erreur avec M. Machin");
        }
        System.out.println("L'auteur du Doc2 est : " + Doc2.getAuteur());
        if (!Doc2.setAuteur("Bernard Durand")) {
            System.out.println("Erreur avec Bernard Durand");
        }
        System.out.println("L'auteur du Doc2 est : " + Doc2.getAuteur());
        
        System.out.println("Le code du Doc2 est : " + Doc2.getCode());
        if (!Doc2.setCode(null)) {
            System.out.println("Erreur avec null");
        }
        System.out.println("Le code du Doc2 est : " + Doc2.getCode());
        if (!Doc2.setCode("967. 4987 T248O")) {
            System.out.println("Erreur avec 967. 4987 T248O");
        }
        System.out.println("Le code du Doc2 est : " + Doc2.getCode());
        if (!Doc2.setCode("962. 4387 Z5487")) {
            System.out.println("Erreur avec 962. 4387 Z5487");
        }
        System.out.println("Le code du Doc2 est : " + Doc2.getCode());
        
        System.out.println("Le titre du Doc2 est : " + Doc2.getTitre());
        if (!Doc2.setTitre(null)) {
            System.out.println("Erreur avec null");
        }
        System.out.println("Le titre du Doc2 est : " + Doc2.getTitre());
        if (!Doc2.setTitre("Structures de Données")) {
            System.out.println("Erreur avec Structures de Données");
        }
        System.out.println("Le titre du Doc2 est : " + Doc2.getTitre());
        if (!Doc2.setTitre("Structures de Données V2")) {
            System.out.println("Erreur avec Structures de Données V2");
        }
        System.out.println("Le titre du Doc2 est : " + Doc2.getTitre());
        
        //emprunter un document 1
        if (!Doc1.emprunterDoc()) {
            System.out.println("Erreur emprunterDoc 1");
        }

        //le retourner 2
        if (!Doc1.retournerDoc()) {
            System.out.println("Erreur retournerDoc 2");
        }

        //le ranger 3
        if (!Doc1.rangerDoc()) {
            System.out.println("Erreur rangerDoc 3");
        }

        //l'emprunter 4
        if (!Doc1.emprunterDoc()) {
            System.out.println("Erreur emprunterDoc 4");
        }

        //le réserver 5
        if (!Doc1.reserverDoc()) {
            System.out.println("Erreur reserverDoc 5");
        }

        //annuler la réservation 6
        if (!Doc1.annulerReservation()) {
            System.out.println("Erreur annulerReservation 6");
        }

        //le réserver 7
        if (!Doc1.reserverDoc()) {
            System.out.println("Erreur reserverDoc 7");
        }

        //essayer de le re réserver 8 ERREUR
        if (!Doc1.reserverDoc()) {
            System.out.println("Erreur reserverDoc 8");
        }

        //le retourner 9
        if (!Doc1.retournerDoc()) {
            System.out.println("Erreur retournerDoc 9");
        }
        
        //le ranger 9.5 ERREUR
        if (!Doc1.rangerDoc()) {
            System.out.println("Erreur rangerDoc 9.5");
        }

        //le récupérer 10
        if (!Doc1.emprunterDoc()) {
            System.out.println("Erreur emprunterDoc 10");
        }

        //le ramener 11
        if (!Doc1.retournerDoc()) {
            System.out.println("Erreur retournerDoc 11");
        }

    }
    
}
