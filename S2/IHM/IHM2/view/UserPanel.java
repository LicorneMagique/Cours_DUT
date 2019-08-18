package fr.scarex.projetihms2.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import fr.scarex.projetihms2.User;

/**
 * @author SCAREX
 *
 */
public class UserPanel extends JPanel
{
    private static final long serialVersionUID = -1677426355662733958L;
    
    public UserPanel(User connected) {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(Box.createRigidArea(new Dimension(400, 2)));
        this.setMinimumSize(new Dimension(150, 100));
        
        UserProfile upp = new UserProfile(null);
        upp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Utilisateur en cours"));
        this.add(upp);
        
        UserProfile upc = new UserProfile(connected);
        upc.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Utilisateur connecté"));
        this.add(upc);
    }
}
