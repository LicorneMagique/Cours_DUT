package newpackage;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class DeleteAction extends AbstractAction {
    Evenements_2 f;
    
    public DeleteAction(Evenements_2 f, String texte) {
    super(texte);
    this.f = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.model2.effaceString((String)f.model2.getSelectedItem());
    }
    
}
