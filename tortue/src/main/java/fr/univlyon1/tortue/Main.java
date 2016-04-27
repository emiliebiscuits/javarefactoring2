/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.tortue;


import fr.univlyon1.tortue.controleur.Controleur;
import fr.univlyon1.tortue.modele.Modele;
import fr.univlyon1.tortue.vue.Vue;

/**
 *
 * @author p1512972
 */
public class Main {

    /**
     * 
     * @param args 
     */
     public static void main(String[] args){

        Modele modele = new Modele();
        Controleur controleur = new Controleur(modele);
        Vue vue = new Vue(controleur);
    } 
  
}
