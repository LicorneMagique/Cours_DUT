package newpackage;

import javax.swing.*;
import java.util.ArrayList;

public class Boutons extends JFrame {
    
    ArrayList<JButton> listeBoutons;
    
    public Boutons(String txt) {
        this.listeBoutons = new ArrayList<>();
        this.listeBoutons.add(new JButton (txt));
    }
}
