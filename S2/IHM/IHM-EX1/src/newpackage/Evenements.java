package newpackage;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Evenements extends JFrame implements ActionListener {
    
     public Evenements(){
        creerFenetre();
    }
     
     private void creerFenetre(){
        this.setTitle("L'exercice de la rage");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        
        
        this.setContentPane(creerPanel());
        this.setVisible(true);
    }
     
    private JPanel creerPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        
        JTextField txt1 = new JTextField();
        
        JLabel label1 = new JLabel();
        
        JButton bouton1 = new JButton("Cliquer ici");
        bouton1.addActionListener((ActionEvent e) -> {
            label1.setText(txt1.getText());
        });
        
        panel.add(txt1);
        panel.add(label1);
        panel.add(bouton1);
        
        return panel;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
    
}
