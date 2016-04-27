/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.tortue.vue;

import fr.univlyon1.tortue.modele.Balle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author Emilie
 */
public class BalleVue extends JPanel{
    private Balle balle;
    private Image img;
    /**
     * Constructeur
     * @param balle 
     */
    public BalleVue(Balle balle){
        super();
        this.balle = balle;
        img = Toolkit.getDefaultToolkit().createImage("images/ball.png");
        setBounds(balle.getPos().getX(),balle.getPos().getY(),32,32);
        setOpaque(false);
    }
    /**
     * Dessiner la balle
     * @param g 
     */
     @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBounds(balle.getPos().getX(),balle.getPos().getY(),35,35);
            g.drawImage(img, 0,0, this);
            
        }
}
