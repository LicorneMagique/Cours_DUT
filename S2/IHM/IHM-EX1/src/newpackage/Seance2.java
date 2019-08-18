package newpackage;

import javax.swing.*;
import java.awt.*;

public class Seance2 extends JFrame {
    
    public Seance2(){
        creerFenetre();
    }
    
    private void creerFenetre(){
        this.setTitle("Calculatrice");
        this.setSize(400, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        
        
        this.setContentPane(creerPanel());
        this.setVisible(true);
    }
    
    public JPanel creerPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JButton bouton1 = new JButton("Cliquez ici !");
        JButton bouton2 = new JButton("Où là");
        panel1.add(bouton1);
        panel1.add(bouton2);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        JButton bouton3 = new JButton("Où encore là !");
        panel2.add(bouton3, BorderLayout.CENTER);
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        JLabel label1 = new JLabel("Sud-Ouest");
        JLabel label2 = new JLabel("Sud-Est");
        panel3.add(label1, BorderLayout.WEST);
        panel3.add(label2, BorderLayout.EAST);
        
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        
        return panel;
        
    }
}