package newpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Seance3_Calculatrice extends JFrame implements ActionListener {
    
    public Seance3_Calculatrice(){
        creerFenetre();
    }
    
    private void creerFenetre(){
        this.setTitle("'Ici' et 'là'");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        
        
        this.setContentPane(creerPanel());
        this.setVisible(true);
    }
    
    public JPanel creerPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        
        JButton bouton1 = new JButton("+");
        bouton1.addActionListener((ActionEvent e) -> {
            System.out.println("+");
        });
        
        JButton bouton2 = new JButton("-");
        bouton2.addActionListener((ActionEvent e) -> {
            System.out.println("-");
        });
        
        JButton bouton3 = new JButton("*");
        bouton3.addActionListener((ActionEvent e) -> {
            System.out.println("*");
        });
        
        JButton bouton4 = new JButton("/");
        bouton4.addActionListener((ActionEvent e) -> {
            System.out.println("/");
        });
        
        JButton bouton5 = new JButton("0");
        bouton5.addActionListener((ActionEvent e) -> {
            System.out.println("0");
        });
        
        JButton bouton6 = new JButton("1");
        bouton6.addActionListener((ActionEvent e) -> {
            System.out.println("1");
        });
        
        JButton bouton7 = new JButton("2");
        bouton7.addActionListener((ActionEvent e) -> {
            System.out.println("2");
        });
        
        JButton bouton8 = new JButton("3");
        bouton8.addActionListener((ActionEvent e) -> {
            System.out.println("3");
        });
        
        JButton bouton9 = new JButton("4");
        bouton9.addActionListener((ActionEvent e) -> {
            System.out.println("4");
        });
        
        JButton bouton10 = new JButton("5");
        bouton10.addActionListener((ActionEvent e) -> {
            System.out.println("5");
        });
        
        JButton bouton11 = new JButton("6");
        bouton11.addActionListener((ActionEvent e) -> {
            System.out.println("6");
        });
        
        JButton bouton12 = new JButton("7");
        bouton12.addActionListener((ActionEvent e) -> {
            System.out.println("7");
        });
        
        JButton bouton13 = new JButton("8");
        bouton13.addActionListener((ActionEvent e) -> {
            System.out.println("8");
        });
        
        JButton bouton14 = new JButton("9");
        bouton14.addActionListener((ActionEvent e) -> {
            System.out.println("9");
        });
        
        JButton bouton15 = new JButton(".");
        bouton15.addActionListener((ActionEvent e) -> {
            System.out.println(".");
        });
        
        JButton bouton16 = new JButton("=");
        bouton16.addActionListener((ActionEvent e) -> {
            System.out.println("=");
        });
        
        panel.add(bouton1);
        panel.add(bouton2);
        panel.add(bouton3);
        panel.add(bouton4);
        panel.add(bouton5);
        panel.add(bouton6);
        panel.add(bouton7);
        panel.add(bouton8);
        panel.add(bouton9);
        panel.add(bouton10);
        panel.add(bouton11);
        panel.add(bouton12);
        panel.add(bouton13);
        panel.add(bouton14);
        panel.add(bouton15);
        panel.add(bouton16);
        
        
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}