/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.tortue.modele;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author emilie
 */
public class Tortue extends Observable{
    /**
     * La position de la tortue
     */
    private Position pos;
    /**
     * La direction du prochain mouvment de la tortue
     */
    private int dir;
    /**
     * La couleur de la tortue
     */
    private Color couleur;
   
    /**
     * Le crayon que la tortue procede, 
     * qui donne la capacite de tracer un prochain segment 
     * et la couleur du prochain segment
     */
  
    
    /**
     * Creation d'une tortue
     * par defaut, la tortue peut dessiner le prochain segment
     * @param x :: la position x de la tortue
     * @param y :: la position y de la tortue
     * @param couleur :: la couleur de la tortue
     */
    public Tortue(int x, int y, Color couleur, int dir) {
        this.pos = new Position(x,y);
        this.couleur = couleur;
        this.dir = dir;
    }
    
      
    /**
     * Accesseur de la position 
     * @return :: la position de la tortue
     */
    public Position getPos() {
        return pos;
    }
    
    /**
     * Accesseur de la direction
     * @return :: la direction de la tortue
     */
    public int getDir() {
        return dir;
    }

    /**
     * Accesseur de la couleur
     * @return :: la couleur de la tortue
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * Mutateur de la position de la tortue,on assure qu'elle ne sort pas du terrain
     * @param x :: la position x que l'on veut mettre
     * @param y :: la position y que l'on veut mettre
     */
    public void setPos(int x, int y) {
        if(x>=25 && x<=750)
            this.pos.setX(x);
        if(y>=25 && y<=475)
            this.pos.setY(y);
            
        setChanged();
        notifyObservers();
    }

    /**
     * Mutateur de la direction de la tortue
     * @param dir :: la direction que l'on veut mettre
     */
    public void setDir(int dir) {
        this.dir = dir;
        setChanged();
        notifyObservers();
    }

    /**
     * Mutateur de la couleur
     * @param couleur :: la couleur que l'on veut mettre
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
        setChanged();
        notifyObservers();
    }

 

    /**
     * Avancer la tortue
     * Recalculer la nouvelle position de la tortue selon sa direction et la distance 
     * @param dist :: la distance que la tortue doit avancer
     */
    public void avancer(int dist) {
        int newX = (int) Math.round(pos.getX()+dist*Math.sin(Math.toRadians(dir)));
        int newY = (int) Math.round(pos.getY()-dist*Math.cos(Math.toRadians(dir)));
        this.setPos(newX,newY);
        setChanged();
        notifyObservers();
    }
    /**
     * 
     * @param dist 
     */
    public void reculer(int dist){
        int newX = (int) Math.round(pos.getX()-dist*Math.sin(Math.toRadians(dir)));
        int newY = (int) Math.round(pos.getY()+dist*Math.cos(Math.toRadians(dir)));
        this.setPos(newX,newY);
        setChanged();
        notifyObservers();
    }
    
    /**
     * Tourner a gauche
     * @param angle :: l'angle de la rotation
     */
    public void gauche(int angle){
        this.setDir(dir-angle);
        setChanged();
        notifyObservers();
    }
    /**
     * Torner a droite
     * @param angle l'angle de la rotation
     */
    public void droite(int angle){
        this.setDir(dir+angle);
        setChanged();
        notifyObservers();
    }
    /**
     * Mettre la tortue au point d'origine
     * Suprrimer la liste des segments
     */
    public void reset() {
        this.setPos(390, 300);
        this.setDir(0);
        setChanged();
        notifyObservers();
    }
    /**
     * Calcul de la distance entre celle-ci et une tortue donnee
     * @param t
     * @return ::  la distatnce calculee
     */
    public int distanceTortue(Tortue t){
        if(t != null){
            double diffX = Math.pow(this.getPos().getX() - t.getPos().getX(),2);
            double diffY = Math.pow(this.getPos().getY() - t.getPos().getY(),2);
            double dist =  Math.sqrt(diffX + diffY);
            return (int)dist;
        }
        return 0;        
    }
    
}
