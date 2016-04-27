/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.tortue.modele;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Emilie
 */
public class Modele extends Observable {
    /**
     * La tortue de base (celle qui bouge en fonction des boutons en haut)
     */
    private Tortue tortue;
    /**
     * Le jeu
     */
    private Jeu jeu;
    /**
     * Constructeur du modele
     */
    public Modele(){
        this.tortue = new Tortue(390,300,Color.BLACK,0);
        this.jeu = new Jeu();
    } 
    /**
     * Accesseur de la tortue de base
     * @return :: la tortue
     */
    public Tortue getTortue() {
        return tortue;
    }
    /**
     * Accesseur du jeu
     * @return :: le jeu
     */
    public Jeu getJeu() {
        return jeu;
    }
    /**
     * Ajouter l'observeur a chaque observable
     * @param o :: Observeur
     */
    public void ajouterObserverAuxObservables(Observer o){
        tortue.addObserver(o);
        jeu.getBalle().addObserver(o);
        Joueur[] liste = jeu.getRose().getJoueurs();
        for(Joueur j : liste){
            j.getTortue().addObserver(o);
        }
        liste = jeu.getBleu().getJoueurs();
        for(Joueur j : liste){
            j.getTortue().addObserver(o);
        }
        jeu.addObserver(o);
    }
}
