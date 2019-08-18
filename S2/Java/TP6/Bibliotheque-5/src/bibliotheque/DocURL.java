package bibliotheque;

public class DocURL extends DocBibliotheque {
    
    private String URL;
    private String description;
    
    public DocURL(String code, String auteur, String newURL, String newDescription) {
        super(code, "", auteur, 0);
        super.setEtatDoc(-1);
        this.URL = newURL;
        this.description = newDescription;
    }
    
    public String getURL() {
        return this.URL;
    }
    
    @Override
    public boolean setURL(String newURL) {
        if (newURL != null && !newURL.equals("")
                && !newURL.equals(this.URL)) {
            this.URL = newURL;
            return true;
        }
        return false;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    @Override
    public boolean setDescription(String newDescription) {
        if (newDescription != null && !newDescription.equals("")
                && !newDescription.equals(this.description)) {
            this.description = newDescription;
            return true;
        }
        return false;
    }
    
    @Override
    public int getTypeDoc() {
        return 2; //DocURL
    }
    
    @Override
    public String toString() {
        return "Code d'archivage : " + super.getCode() +
                "\nAuteur ou entreprise ayant publié le document : " + super.getAuteur() +
                "\nURL du document : " + this.URL +
                "\nDescription du document : " + this.description;
    }
    
    @Override
    public String toStringOneLine() {
        return "\"" + this.URL
                + "\" de " + super.getAuteur();
    }
    
}
