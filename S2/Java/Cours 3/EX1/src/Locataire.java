public class Locataire {
    private String nomLocataire = "Pas encore de nom";
    private String adresseLocataire = "Pas encore d'adresse";
    private double montantLoyer = 0.0;
    private double montantTaxeHabitation = 0.0;
    
    public Locataire(String newNomLocataire,
                     String newAdresseLocataire,
                     double newMontantLoyer,
                     double newMontantTaxeHabitation) {
            nomLocataire = newNomLocataire;
            adresseLocataire = newAdresseLocataire;
            montantLoyer = newMontantLoyer;
            montantTaxeHabitation = newMontantTaxeHabitation;
    }
    
    public String toString() {
        return ("Nom locataire : " + nomLocataire +
                "\nAdresse locataire : " + adresseLocataire +
                "\nMontant loyer : " + montantLoyer +
                "\nMontant taxe d'habitation : " + montantTaxeHabitation);
    }
}