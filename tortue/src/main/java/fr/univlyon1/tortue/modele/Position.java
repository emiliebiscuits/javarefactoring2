/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.tortue.modele;

/**
 *
 * @author emilie
 */
public class Position {
    /**
     * position de l'axe x
     */
    private int x;
    /**
     * position de l'axe y
     */
    private int y;
    
    /**
     * Creation d'une position
     * @param x :: position x
     * @param y :: position y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Accesseur de x
     * @return :: position x
     */
    public int getX() {
        return x;
    }
    
    /**
     * Accesseur de y
     * @return :: position y
     */
    public int getY() {
        return y;
    }
    
    /**
     * Mutateur de x
     * @param x :: la valeur que l'on veut mettre 
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Mutateur de y
     * @param y :: la valeur que l'on veut mettre
     */
    public void setY(int y) {
        this.y = y;
    }
    
}
