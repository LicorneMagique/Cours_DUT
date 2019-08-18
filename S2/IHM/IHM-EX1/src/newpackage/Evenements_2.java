package newpackage;

import java.awt.GridLayout;
import javax.swing.*;

public class Evenements_2 extends JFrame {
    
    
    String[] tab = new String[] {"c'est beau le texte", "c'est sympa chez vous"};
    ModeleCBString model1 = new ModeleCBString(tab);
    ModeleCBString model2 = new ModeleCBString();
    
    
    public Evenements_2(){
        JFrame fenetre = creerFenetre();
    }
    
    
    private JFrame creerFenetre(){
        //~~JFrame this = new JFrame();
        this.setTitle("Exercice Évènements");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setContentPane(creerPanel());
        this.setVisible(true);
        return this;
    }
     
    private JPanel creerPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        JLabel label1 = new JLabel();
        
        JComboBox<String> jcb1 = new JComboBox<>(model1);
        JComboBox<String> jcb2 = new JComboBox<>(model2);
        
        JButton bouton1 = new JButton(new CopyAction(this, "copier un élément du premier jcb"));
        
        JButton bouton2 = new JButton(new DeleteAction(this, "supprimer un élément du second jcb"));
        
        JButton bouton3 = new JButton(new ClearAction(this, "vider tout le second jcb"));
        
        panel.add(jcb1);
        panel.add(jcb2);
        panel.add(bouton1);
        panel.add(bouton2);
        panel.add(bouton3);
        
        return panel;
        
    }
    
}
