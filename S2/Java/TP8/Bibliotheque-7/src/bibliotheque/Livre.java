package bibliotheque;

public class Livre extends DocBibliotheque {
    
    private String nomEditeur;
    private int nbPage;
    private String ISBN;
    
    public Livre(String code, String titre, String auteur, int annee,
            String newNomEditeur, int newNbPage, String newISBN) {
        super(code, titre, auteur, annee);
        this.nomEditeur = newNomEditeur;
        this.nbPage = newNbPage;
        this.ISBN = newISBN;
    }
    
    public String getNomEditeur() {
        return this.nomEditeur;
    }
    
    @Override
    public boolean setNomEditeur(String newNomEditeur) {
        if (newNomEditeur != null && !newNomEditeur.equals("")
                && !newNomEditeur.equals(this.nomEditeur)) {
            this.nomEditeur = newNomEditeur;
            return true;
        }
        return false;
    }
    
    public int getNbPage() {
        return this.nbPage;
    }
    
    @Override
    public boolean setNbPage(int newNbPage) {
        if (newNbPage != 0) {
            this.nbPage = newNbPage;
            return true;
        }
        return false;
    }
    
    public String getISBN() {
        return this.ISBN;
    }
    
    @Override
    public boolean setISBN(String newISBN) {
        if (newISBN != null && !newISBN.equals("")
                && !this.ISBN.equals(newISBN)) {
            this.ISBN = newISBN;
            return true;
        }
        return false;
    }
    
    @Override
    public int getTypeDoc() {
        return 3; //Livre
    }
    
    @Override
    public String toString() {
        return super.toString() + //code + titre + auteur + année + emprunteur + réserveur
            "\nNom de l'éditeur : " + this.nomEditeur +
            "\nNombre de pages : " + this.nbPage +
            "\nISBN : " + this.ISBN;
    }
}
