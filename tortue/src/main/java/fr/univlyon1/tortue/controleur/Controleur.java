/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.tortue.controleur;
import fr.univlyon1.tortue.modele.Joueur;
import java.awt.event.ActionEvent;
import fr.univlyon1.tortue.modele.Modele;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author Emilie
 */
public class Controleur implements ActionListener{
    Modele modele;
    private int bas;
    private boolean dejaLancer;
    
    /**
     * 
     * @param m 
     */
    public Controleur(Modele m){
        this.modele = m;
        this.bas = 25;
        this.dejaLancer = false;
    }
    /**
     * 
     * @return 
     */
    public Modele getModele() {
        return modele;
    }
    /**
     * Determiner ce que l'on veut faire selon l'action captee
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
	String action = e.getActionCommand();
        String source = e.getSource().getClass().getName();
        if(action.equals("Quitter"))
        {
            System.exit(0);
        }
        else if(action.equals("Effacer"))
        {
            modele.getTortue().reset();
        }
        else if(action.equals("Avancer"))
        {
            modele.getTortue().avancer(bas);
        }
        else if(action.equals("Reculer"))
        {
            modele.getTortue().reculer(bas);
        }
        else if(action.equals("Droite"))
        {
            int dir = modele.getTortue().getDir();
            modele.getTortue().droite(bas);
        }
        else if(action.equals("Gauche"))
        {
            modele.getTortue().gauche(bas);
        }
        else if(action.equals("Lancer"))
        {
            if(dejaLancer == false){
               modele.getJeu().InitThread();
               modele.getJeu().getThread().start();
               dejaLancer = true;
            }   
        }
        else if(action.equals("Arreter"))
        {
            modele.getJeu().setSuspendu(true);
            dejaLancer = false;
        }
        else if(action.equals("Initialiser")){
            modele.getJeu().setSuspendu(true);
            dejaLancer = false;
            modele.getJeu().reset();
        }
        else if(action.equals("Rose : Mouvement")){
            modele.getJeu().getRose().setTactique(0);
        }
        else if(action.equals("Rose : Passe")){
            modele.getJeu().getRose().setTactique(1);
        }
        else if(action.equals("Rose : Attaque")){
            modele.getJeu().getRose().setTactique(2);
        }
        else if(action.equals("Bleu : Mouvement")){
            modele.getJeu().getBleu().setTactique(0);
        }
        else if(action.equals("Bleu : Passe")){
            modele.getJeu().getBleu().setTactique(1);
        }
        else if(action.equals("Bleu : Attaque")){
            modele.getJeu().getBleu().setTactique(2);
        }
        else if(source.equals("javax.swing.JTextField"))
        {
            bas = Integer.parseInt(action);
        }
        
    }
    
  
}
