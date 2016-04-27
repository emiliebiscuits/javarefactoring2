/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.tortue.modele;

import java.awt.Color;

/**
 *
 * @author Emilie
 */
public class Balle extends Tortue{

    /**
     * Le joueur qui a la balle
     */
    private Joueur maitre;
    /**
     * La balle doit connaitre le jeu pour pouvoir mettre a jour le score selon sa position
     */
    private Jeu jeu;
    /**
     * Cette valeur est seulement pour eviter d'ajouter plusieurs fois le meme but
     */
    private boolean dejaAjouter = false;
    /**
     * Constructeur de la balle
     * @param x
     * @param y
     * @param couleur
     * @param dir 
     * @param j :: le jeu
     */
    public Balle(int x, int y, Color couleur, int dir,Jeu j) {
        super(x, y, couleur, dir);
        this.jeu = j;
    }
    /**
     * Accesseur du maitre
     * @return 
     */
    public Joueur getMaitre() {
        return maitre;
    }
    /**
     * Chngement de maitre
     * @param j 
     */
    public void setMaitre(Joueur j){
        if(this.maitre != null){
            maitre.setAvoirBalle(false);
        }
         this.maitre = j;
         setChanged();
         notifyObservers();
         j.setAvoirBalle(true);
         this.suivreMaitre();
    }
    /**
     * La balle suit son maitre
     */
    public void suivreMaitre(){
        if(maitre!=null){
            int x = maitre.getTortue().getPos().getX();
            int y = maitre.getTortue().getPos().getY();
            int dir = maitre.getTortue().getDir();
            int newX = (int) (x + 28 + 28 * Math.sin(Math.toRadians(dir)));
            int newY = (int) (y + 28 - 28 * Math.cos(Math.toRadians(dir)));
            this.setPos(newX,newY);
        }
        dectecterScore();
    }

    /**
     * Determinier si le score du but est deja aujoute
     * @return 
     */
    public boolean isDejaAjouter() {
        return dejaAjouter;
    }
    
    
    
   /**
    *  Mettre a jour le score selon sa position
    */
    public void dectecterScore(){
        int x = getPos().getX();
        int y = getPos().getY();
        if(y<340 && y>180 && x<45)
        {
            if(dejaAjouter==false)
            {
                jeu.setScoreRose(jeu.getScoreRose()+1);
                dejaAjouter=true;
            }
        }
        else if(y<340 && y>180 && x>725)
        {
             if(dejaAjouter==false)
            {
                jeu.setScoreBleu(jeu.getScoreBleu()+1);
                dejaAjouter=true;
            }
        }
        else
        {
            dejaAjouter=false;
        }
    }
}
