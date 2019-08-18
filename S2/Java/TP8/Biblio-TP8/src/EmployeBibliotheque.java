public class EmployeBibliotheque implements Notifiable {

    private String numEmp;
    private String nomEmp;
    
    public EmployeBibliotheque(String newNumEmp, String newNomEmp) {
        this.numEmp = newNumEmp;
        this.nomEmp = newNomEmp;
    }
    
    @Override
    public void docDisponible(DocBibliotheque doc) {
        System.out.println("Document disponible");
    }
    
    public void utilisationDoc(DocBibliotheque doc) {
        doc.setEtatPhysique("supprime");
    }
}
