package newpackage;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class ClearAction extends AbstractAction {

    Evenements_2 f;
    
    public ClearAction(Evenements_2 f, String texte) {
    super(texte);
    this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.model2.effaceTout();
    }
    
}

