package fr.scarex.projetihms2.view;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.scarex.projetihms2.User;

/**
 * @author SCAREX
 * 
 */
public class UserProfile extends JPanel
{
    private static final long serialVersionUID = -851178287083432033L;
    public User user;

    public UserProfile(User u) {
        this.user = u;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(new ImagePanel(user != null && user.getUserPic().exists() ? user.getUserPic() : User.getDefaultPic(), 200, 200));

        this.add(new JLabel(user != null ? user.getId() : "Aucune personne"));
    }
}
