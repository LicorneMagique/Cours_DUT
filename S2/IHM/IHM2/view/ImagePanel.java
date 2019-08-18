package fr.scarex.projetihms2.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author SCAREX
 * 
 */
public class ImagePanel extends JPanel
{
    private static final long serialVersionUID = -7859150893232938676L;
    private BufferedImage image;
    private int width;
    private int height;

    public ImagePanel(File f, int width, int height) {
        this.width = width;
        this.height = height;
        try {
            image = ImageIO.read(f);
        } catch (IOException ex) {}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, width, height, this);
    }
}
