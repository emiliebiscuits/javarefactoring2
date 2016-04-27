/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.tortue.vue;


import fr.univlyon1.tortue.controleur.Controleur;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

/**
 *
 * @author p1512972
 */
public final class Vue extends JFrame implements Observer{

    private final Controleur controleur;
    private Fenetre1 f1;
    private Fenetre2 f2;
    private Fenetre3 f3;
    /**
     * Constructeur de la vue
     * @param controleur :: le controleur du programme
     */
    public Vue (Controleur controleur){
        this.controleur = controleur;
        controleur.getModele().ajouterObserverAuxObservables(this);
        f1 = new Fenetre1(controleur);
        f2 = new Fenetre2(controleur);
        f3 = new Fenetre3(controleur);
    }
    
    /**
     * fonction par defaut de Observeur
     * @param o
     * @param arg 
     */
   
    @Override
    public void update(Observable o, Object arg) {
        f1.repaint();
        f2.mettreAJourScore();
        f2.repaint();
        f3.MettreAJourTexte();
        f3.repaint();
    }
    
}
    
 
    
  