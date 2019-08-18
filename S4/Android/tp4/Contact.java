package fr.olivierpautrat.tp4;

import java.io.Serializable;

public class Contact implements Serializable {
    private String nom;
    private String prenom;
    private Genre genre;
    private String telephone;
    private String courriel;
    private String adresse;
    private int cp;
    private String photo;

    /**
     *
     * @param nom
     * @param prenom
     * @param genre
     * @param telephone
     * @param courriel
     * @param adresse
     * @param cp
     * @param photo
     */
    public Contact(String nom, String prenom, Genre genre, String telephone, String courriel, String adresse, int cp,
            String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.telephone = telephone;
        this.courriel = courriel;
        this.adresse = adresse;
        this.cp = cp;
        this.photo = photo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }
}
