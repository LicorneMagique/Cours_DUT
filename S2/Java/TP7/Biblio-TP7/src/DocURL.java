public class DocURL extends DocBibliotheque {
    
    private String url = null;
    private String description = null;

    public DocURL (String codeArch, String titreDoc,
            String nomAut, int anneePub, String newUrl, String newDescription) {
        super(codeArch, titreDoc, nomAut, anneePub);
        this.url = newUrl;
        this.description = newDescription;
       
    }

       
    @Override
    public void emprunter(MembreBibliotheque membre){
       System.out.println("Ce document n'est pas empruntable.");
    }
    
    @Override
    public void reserver(MembreBibliotheque membre){
       System.out.println("Ce document n'est pas réservable.");
    }
    
    public void retournerDoc(MembreBibliotheque membre){
        System.out.println("Ce document n'est pas retournable.");
    }

    @Override
    public void annulerReservation(MembreBibliotheque membreQuiAnnule) {
        System.out.println("Ce document n'est pas réservé.");
    }

    @Override
    public void rangerDoc() {
        System.out.println("Ce document n'est pas rangeable.");
    }
    
    @Override
    public String toString() {
        return (super.toString() +
                "\nLien de l'url : " + url +
                "\nDescription :" + description);
    }
    
}