package fr.scarex.projetihms2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import fr.scarex.projetihms2.User;

/**
 * @author SCAREX
 * 
 */
public class ProjetIHM extends JFrame
{
    private static final long serialVersionUID = 5920166087186458070L;
    public static final String SOFTWARE_DATA = System.getProperty("user.dir") + "/gca";
    public User connected = null;

    public static void main(String[] args) {
        (new File(SOFTWARE_DATA, User.PIC_DATABASE)).mkdirs();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        (new ProjetIHM()).setVisible(true);
    }

    public ProjetIHM() {
        this.connected = generateConnectionDialog();

        this.setTitle("Gestion des cartes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainP = new JPanel();
        mainP.setLayout(new BorderLayout());

        mainP.add(new UserPanel(connected), BorderLayout.WEST);

        mainP.add(new MainPanel(), BorderLayout.CENTER);

        this.setContentPane(mainP);
        this.setMinimumSize(new Dimension(900, 600));
        this.setLocationRelativeTo(null);
    }

    private User generateConnectionDialog() {
        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();

        final JComponent[] comp = new JComponent[] {
                new JLabel("Utilisateur :"),
                user,
                new JLabel("Mot de passe :"),
                pass };

        int r = JOptionPane.showConfirmDialog(null, comp, "Connection", JOptionPane.PLAIN_MESSAGE);

        if (r == JOptionPane.OK_OPTION) { return new User(user.getText(), new String(pass.getPassword())); }

        return null;
    }
}
