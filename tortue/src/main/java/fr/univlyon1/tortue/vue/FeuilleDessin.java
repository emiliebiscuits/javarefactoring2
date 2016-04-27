package fr.univlyon1.tortue.vue ;

import fr.univlyon1.tortue.modele.Modele;
import fr.univlyon1.tortue.modele.Tortue;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
 * Titre :        Logo
 * Description :  Un exemple de programme graphique utilisant la celebre Tortue Logo
 * Copyright :    Copyright (c) 2000
 * Societe :      LIRMM
 * @author J. Ferber
 * @version 2.0
 */

public class FeuilleDessin extends JPanel {
	
        Image im;
        /**
         * Constructeur du terrain
         */
	public FeuilleDessin() {
            
            im = Toolkit.getDefaultToolkit().createImage("images/terrain.png"); 
	}
        /**
         * Dessiner le terrain
         * @param g 
         */
        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            g.drawImage(im, 0, 0, this);
          
        }
	
}
