/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.tortue.vue;

import java.awt.Color;
import java.awt.Graphics;
import fr.univlyon1.tortue.modele.Tortue ;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author p1512972
 */
public class TortueVue extends JPanel{
    
    private Tortue tortue ;
    private Image img;
	
	/**
         * Constructeur de la vue d'une tortue
         * @param tortue 
         */
	public TortueVue(Tortue tortue) { 
            super();
            this.tortue  = tortue ;
            if(tortue.getCouleur() == Color.PINK)
            {
                img = Toolkit.getDefaultToolkit().createImage("images/tortue2.png");
            }
            else if(tortue.getCouleur() == Color.BLUE)
            {
                img = Toolkit.getDefaultToolkit().createImage("images/tortue3.png");
            }
            else
            {
                img = Toolkit.getDefaultToolkit().createImage("images/tortue1.png");
            }
           setBounds(tortue.getPos().getX(),tortue.getPos().getY(),70,70);
            
            setOpaque(false);
	}

        /**
         * Dessiner la tortue
         * @param g 
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            setBounds(tortue.getPos().getX(),tortue.getPos().getY(),70,70);
            g2d.rotate(Math.toRadians(tortue.getDir()),28,28);
            g2d.drawImage(img, 0,0, this);
            
        }
    /**
     * Re initialiser la tortue
     */	
    public void reset() {
        this.tortue.reset() ;
    }
}

    

