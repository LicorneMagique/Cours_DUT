package personnel.vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.swing.*;
import personnel.dao.IAdministratifDAO;
import personnel.dao.oracle.OracleAdministratifDAO;
import personnel.dao.oracle.OracleDataSourceDAO;
import personnel.métier.Administratif;

public class Fenetre extends javax.swing.JFrame implements ActionListener {
    private final List<Administratif> listeAdministratif;
    private static IAdministratifDAO AdministratifDAO;
    private static DataSource dataSourceDAO;
    private static Connection connexionBD;


    public Fenetre() {
        listeAdministratif = AdministratifDAO.getLesObjetsClasseMétier();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) throws SQLException {                                   
        quitter(); // fermeture de la connexion
    }
    
    private void quitter() throws SQLException{
        connexionBD.close();
    }

    private static JFrame creerFenetre(){
        JFrame fenetre = new JFrame();
        fenetre.setSize(400, 400);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(true);
        fenetre.setContentPane(creerPanel());
        fenetre.setVisible(true);
        return fenetre;
    }
    
    private static JPanel creerPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //JLabel label1 = new JLabel();
        
        JLabel label1 = new JLabel("LISTE DES ADMINISTRATIFS");
        JLabel label2 = new JLabel("Numéro Administratif :");
        JLabel label3 = new JLabel("Nom Administratif :");
        JLabel label4 = new JLabel("Numéro de Bureau :");
        JLabel label5 = new JLabel("Salaire mensuel :");
        
        JTextField txt1 = new JTextField();
        JTextField txt2 = new JTextField();
        JTextField txt3 = new JTextField();
        JTextField txt4 = new JTextField();
                
        JButton bouton1 = new JButton("<<");
        JButton bouton2 = new JButton(">>");
        JButton bouton3 = new JButton("Ajouter");
        JButton bouton4 = new JButton("Supprimer");
        
        
        //bouton1.addActionListener((ActionEvent e) -> {});
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(label1);
        
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 2));
        panel3.add(label2);
        panel3.add(txt1);
        
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1, 2));
        panel4.add(label3);
        panel4.add(txt2);
        
        JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayout(1, 2));
        panel5.add(label4);
        panel5.add(txt3);
        
        JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayout(1, 2));
        panel6.add(label5);
        panel6.add(txt4);
        
        JPanel panel7 = new JPanel();
        panel7.setLayout(new FlowLayout());
        panel7.add(bouton1);
        panel7.add(bouton2);
        
        JPanel panel8 = new JPanel();
        panel8.setLayout(new FlowLayout());
        panel8.add(bouton3);
        panel8.add(bouton4);
        
        panel.add(new JLabel(" "));
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);
        panel.add(panel6);
        panel.add(panel7);
        panel.add(panel8);

        return panel;
        
    }

    public static void main(String args[]) {

        JFrame fenetre = creerFenetre();
        
        
        java.awt.EventQueue.invokeLater(() -> {
            try {
                dataSourceDAO = OracleDataSourceDAO.getOracleDataSourceDAO();
                OracleAdministratifDAO v_AdministratifDAO = new OracleAdministratifDAO();
                v_AdministratifDAO.setDataSource(dataSourceDAO);
                connexionBD = dataSourceDAO.getConnection();
                v_AdministratifDAO.setConnection(connexionBD);
                new Fenetre().setVisible(true);
            } catch (SQLException | IOException ex) {
                Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

}