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
public class Equipe {
    private Joueur[] joueurs;
    private Color couleur;
    private Position butPos;
    private static Balle balle;
    /**
     * Constructeur de l'equipe
     * @param couleur :: couleur de l'equipe
     * @param b :: la balle du jeu
     */
    public Equipe(Color couleur,Balle b){
        this.couleur = couleur;
        joueurs = new Joueur[3];
        Equipe.balle = b;
        if(couleur == Color.PINK)
        {
            this.butPos = new Position(775,250);
            joueurs[0]= addJoueur(200,100,120,0,butPos);
            joueurs[1]= addJoueur(85,250,180,1,butPos);
            joueurs[2]= addJoueur(200,400,45,2,butPos);
        }
        else
        {
            this.butPos = new Position(25,250);
            joueurs[0]= addJoueur(575,100,240,0,butPos);
            joueurs[1]= addJoueur(695,250,0,1,butPos);
            joueurs[2]= addJoueur(575,400,315,2,butPos);           
        }
    }
    /**
     * Fonction qui ajoute un joueur dans l'equipe, utilisee seulement a la construction de l'equipe
     * @param posx :: position x initiale du joueur
     * @param posy :: position y initiale du joueur
     * @param dir :: direction initiale du joueur
     * @param role :: role du joueur, ne change pas en cours du jeu
     * @param p :: la position but du joueur
     * @return :: lr joueur cree
     */
    private Joueur addJoueur(int posx, int posy, int dir,int role,Position p){
        Tortue t = new Tortue(posx,posy,couleur,dir);
        Joueur j = new Joueur(t,0,role,p,balle);
        return j;
    }

    /**
     * Accesseur des joueurs
     * @return :: tous les joueurs sur le  terrain
     */
    public Joueur[] getJoueurs() {
        return joueurs;
    }
    /**
     * Accesseur de la position du but
     * @return :: la position du but
     */
    public Position getButPos() {
        return butPos;
    }
    
    /**
     * Reinitialisation des joueurs
     */
    public void reset(){
        if(couleur == Color.PINK){
            joueurs[0].getTortue().setPos(200, 100);
            joueurs[0].getTortue().setDir(120);
            joueurs[1].getTortue().setPos(85, 250);
            joueurs[1].getTortue().setDir(180);
            joueurs[2].getTortue().setPos(200, 400);
            joueurs[2].getTortue().setDir(45);
        }
        else{
            joueurs[0].getTortue().setPos(575, 100);
            joueurs[0].getTortue().setDir(240);
            joueurs[1].getTortue().setPos(695, 250);
            joueurs[1].getTortue().setDir(0);
            joueurs[2].getTortue().setPos(575, 400);
            joueurs[2].getTortue().setDir(315);
        }
    }
    /**
     * Mutateur de la tactique, est appele en fonction de l'utilisateur et l'avancement du jeu
     * @param tactique :: la tactique que l'on veut mettre
     */
    public void setTactique(int tactique){
        for(Joueur j:joueurs){
            j.setTactique(tactique);
        }
    }
}
    
    