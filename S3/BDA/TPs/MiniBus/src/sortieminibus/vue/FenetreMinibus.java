package sortieminibus.vue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import sortieminibus.dao.IMiniBusDAO;
import sortieminibus.dao.oracle.OracleDataSourceDAO;
import sortieminibus.dao.oracle.OracleMinibusDAO;
import sortieminibus.metier.MiniBus;

public class FenetreMinibus extends javax.swing.JFrame {
    
    public static List<MiniBus> listeMinibus;
    private static IMiniBusDAO minibusDAO;
    private static DataSource dataSourceDAO;
    private static Connection connexionBD;
    private static int maxMinibus = 0;

    public static int getLengthListeMinibus() {
        return FenetreMinibus.maxMinibus;
    }

    public FenetreMinibus() {
        minibusDAO = new OracleMinibusDAO();
        listeMinibus = null;
    }
    
    public static List<MiniBus> getListeMinibus() {
        return listeMinibus;
    }
    
    public void formWindowClosing(java.awt.event.WindowEvent evt) {
        quitter();
    }
    
    public void quitter() {
        try {
            connexionBD.close();
        } catch (SQLException ex) {
            Logger.getLogger(FenetreMinibus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                dataSourceDAO = OracleDataSourceDAO.getOracleDataSourceDAO();
                minibusDAO = (IMiniBusDAO) new OracleMinibusDAO();
                minibusDAO.setDataSource(dataSourceDAO);
                connexionBD = dataSourceDAO.getConnection();
                minibusDAO.setConnection(connexionBD);
                listeMinibus = minibusDAO.getLesObjetsMiniBus();
                maxMinibus = listeMinibus.size();
                
                //Création de la fenêtre
                Window fenetre = new Window();
                fenetre.setVisible(true);
                fenetre.updateAffichage();
                
                
                
                
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(FenetreMinibus.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
