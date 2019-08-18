package newpackage;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class CopyAction extends AbstractAction {
    Evenements_2 f;
    
    public CopyAction(Evenements_2 f, String texte) {
    super(texte);
    this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.model2.ajoutString((String)f.model1.getSelectedItem());
    }
    
}
