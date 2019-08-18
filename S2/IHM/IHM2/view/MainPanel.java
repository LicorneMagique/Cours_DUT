package fr.scarex.projetihms2.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @author SCAREX
 * 
 */
public class MainPanel extends JTabbedPane
{
    private static final long serialVersionUID = -8628480569571192713L;

    public MainPanel() {
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Test 1"));
        this.addTab("Test", p1);
    }
}
