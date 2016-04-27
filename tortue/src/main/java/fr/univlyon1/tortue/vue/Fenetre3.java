/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.tortue.vue;

import fr.univlyon1.tortue.controleur.Controleur;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Emilie
 */
public class Fenetre3 extends JFrame{
    private Controleur controleur;
    private JPanel panel;
    private JLabel label;
     /**
     * Constructeur de la fenetre 3
     * @param controleur :: le controleur du programmes
     */
    public Fenetre3(Controleur controleur){
        super("Equipe qui a la balle");
        this.setSize(250, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.controleur = controleur;
        panel = new JPanel();
        getContentPane().add(panel);
        
        label = new JLabel();
        panel.add(label);
        Color c = controleur.getModele().getJeu().getBalle().getMaitre().getTortue().getCouleur();
        String texte;
        
        if(c == Color.PINK)
        texte = "Equipe ROSE a la balle";
        else
        texte = "Equipe BLEU a la balle";
        
        label.setText(texte);
        this.setVisible(true);
    }
    /**
     * Mettre a jour l'affichage de l'equipe qui a la balle
     */
   public void MettreAJourTexte(){
       Color c = controleur.getModele().getJeu().getBalle().getMaitre().getTortue().getCouleur();
        String texte;
        
        if(c == Color.PINK)
        texte = "Equipe ROSE a la balle";
        else
        texte = "Equipe BLEU a la balle";
        
        label.setText(texte);
   }
    
}
