package newpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Seance3 extends JFrame implements ActionListener {
    
    public Seance3(){
        creerFenetre();
    }
    
    private void creerFenetre(){
        this.setTitle("'Ici' et 'là'");
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
        JButton bouton1 = new JButton("Ici");
        JButton bouton2 = new JButton("Là");
        
        bouton1.addActionListener((ActionEvent e) -> {
            System.out.println("UNICOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOORN");
        });
        bouton2.addActionListener((ActionEvent e) -> {
            System.out.println("GALLOPU");
        });
        
        panel1.add(bouton1);
        panel1.add(bouton2);
        
        panel.add(panel1);
        
        
        return panel;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}