/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.tortue.modele;

import java.awt.Color;
import java.util.Observable;

/**
 *
 * @author Emilie
 */
public class Jeu extends Observable{
   private int scoreRose;
   private int scoreBleu;
   private final Balle balle;
   private final Equipe rose;
   private final Equipe bleu;
   private boolean suspendu;
   private Thread thread;
   /**
    * Constructeur du jeu
    */
   public Jeu() {
       this.scoreBleu = 0;
       this.scoreRose = 0;
       this.balle = new Balle(0,0,Color.BLACK,0,this);
       this.rose = new Equipe(Color.PINK,balle);
       this.bleu = new Equipe(Color.BLUE,balle);
       this.suspendu = false;
       balle.setMaitre(rose.getJoueurs()[0]);
   }
   /**
    * Creation du thread
    */
   public void InitThread(){
        this.suspendu = false;
        thread = new Thread(){
        public void run(){
            Joueur[] liste1 = bleu.getJoueurs();
            Joueur[] liste2 = rose.getJoueurs();
               while(!suspendu)
            {
                for(Joueur j : liste1){
                    j.jouer();
                }
                for(Joueur j : liste2){
                    j.jouer();
                }
                balle.suivreMaitre();
                try 
                {
                   sleep(30);
                } 
                catch (InterruptedException ex) 
                {
                    interrupt();
                }
            }
        }
    };
    }
   /**
    * Accesseur du thread
    * @return :: le thread 
    */
   public Thread getThread() {
        return thread;
    }
    /**
     * Mutateur de la valeur suspendu, est appele chaque fois quand utilisateur veut mettre le jeu en pause
     * @param suspendu :: la valeur boolean
     */
    public void setSuspendu(boolean suspendu) {
        this.suspendu = suspendu;
    }
    
    /**
     * Accesseur du score de l'equipe rose
     * @return :: le score
     */
    public int getScoreRose() {
        return scoreRose;
    }

    /**
     * Accesseur du score de l'equipe bleu
     * @return :: le score
     */
    public int getScoreBleu() {
        return scoreBleu;
    }
    
    /**
     * Accesseur de la balle
     * @return :: la balle
     */
    public Balle getBalle() {
        return balle;
    }

    /**
     * Mutateur du score
     * @param scoreRose 
     */
    public void setScoreRose(int scoreRose) {
        this.scoreRose = scoreRose;
        setChanged();
        notifyObservers();
    }

    /**
     * Mutateur du score
     * @param scoreBleu 
     */
    public void setScoreBleu(int scoreBleu) {
        this.scoreBleu = scoreBleu;
        setChanged();
        notifyObservers();
    }
    
    /**
     * Accesseur de l'equipe rose
     * @return 
     */
    public Equipe getRose() {
        return rose;
    }
    /**
     * Accesseur de l'equipe bleu
     * @return 
     */
    public Equipe getBleu() {
        return bleu;
    }
    /**
     * Re-initialisation du jeu
     */
    public void reset(){
        rose.reset();
        bleu.reset();
        setScoreRose(0);
        setScoreBleu(0);
    }
}
