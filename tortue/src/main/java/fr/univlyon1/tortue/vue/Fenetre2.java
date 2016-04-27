/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.tortue.vue;

import fr.univlyon1.tortue.controleur.Controleur;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Emilie
 */
public class Fenetre2 extends JFrame{
    private Controleur controleur;
    private final JPanel panel;
    private final JPanel scorePanel;
    private JLabel score;
    private final JButton[] buttons = new JButton[9];
    /**
     * Constructeur de la fenetre 2
     * @param controleur :: le controleur du programmes
     */
    public Fenetre2(Controleur controleur){
        super("Panel de controle");
        this.setSize(500, 300);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.controleur = controleur;
        this.panel = new JPanel(new GridLayout(3,3));
        
        this.getContentPane().add(panel);
        
        buttons[0] = new JButton("Lancer");
        buttons[1] = new JButton("Arreter");
        buttons[2] = new JButton("Initialiser");
        buttons[3] = new JButton("Rose : Mouvement");
        buttons[4] = new JButton("Rose : Passe");
        buttons[5] = new JButton("Rose : Attaque");
        buttons[6] = new JButton("Bleu : Mouvement");
        buttons[7] = new JButton("Bleu : Passe");
        buttons[8] = new JButton("Bleu : Attaque");
        for(int i=0;i< 9;i++){
           ajouterBouttonDansPanel(panel,buttons[i]);
        }
        this.scorePanel = new JPanel();
        this.getContentPane().add(scorePanel,"South");
        int scoreRose = controleur.getModele().getJeu().getScoreRose();
        int scoreBleu = controleur.getModele().getJeu().getScoreBleu();
        score = new JLabel();
        score.setText("Score: "+scoreRose+" vs "+scoreBleu);
        scorePanel.add(score);
        score.repaint();
        this.setVisible(true);
    }

   /**
    * Mettre a jour le score
    */
    public void mettreAJourScore(){
        int scoreRose = controleur.getModele().getJeu().getScoreRose();
        int scoreBleu = controleur.getModele().getJeu().getScoreBleu();
        score.setText("Score: "+scoreRose+" vs "+scoreBleu);
    }
    /**
     * 
     * @param panel
     * @param b 
     */
    private void ajouterBouttonDansPanel(JPanel panel, JButton b){
        panel.add(b);
        b.addActionListener(this.controleur);
    }
}
