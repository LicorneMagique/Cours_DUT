public class Livre extends DocBibliotheque {
    private String NomEditeur = null;
    private int NombreDePages = 0;
    private String ISBN = null;
    
    public Livre(String newCode, String newTitre,
                 String newAuteur, int newAnnee,
                 String newNomEditeur,
                 int newNombreDePages, String newISBN) {
        super(newCode, newTitre, newAuteur, newAnnee);
        this.NomEditeur = newNomEditeur;
        this.NombreDePages = newNombreDePages;
        this.ISBN = newISBN;
    }
    
    @Override
    public String toString() {
        return super.toString() +
            "\nNom de l'éditeur : " + this.NomEditeur +
            "\nNombre de pages : " + this.NombreDePages +
            "\nISBN : " + this.ISBN;
    }
}
