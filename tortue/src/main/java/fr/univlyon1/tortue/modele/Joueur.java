/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.tortue.modele;

import java.util.ArrayList;

/**
 *
 * @author Emilie
 */
public class Joueur{

    private Tortue tortue;
    private boolean avoirBalle;
    private int tactique;
    private int role;
    private Position butPos;
    private static Balle balle;
    private static ArrayList<Joueur> joueurs = new ArrayList();
    /**
     * Constructeur du joueur
     * @param t :: la tortue du joueur
     * @param tactique :: tactique du joueur
     * @param role :: role du joueur, 0-attaquelent, 1-defense, 2-attaquerapide
     * @param pos :: la position du but du joueur
     */
    public Joueur(Tortue t,int tactique, int role, Position pos,Balle b){
        this.tortue = t;
        this.tactique = tactique;
        this.avoirBalle = false;
        this.role = role;
        this.butPos = pos;
        Joueur.balle = b;
        joueurs.add(this);
    }

    /**
     * Mutateur de avoirBalle
     * @param avoirBalle :: la valeur boolean que l'on veut mettre, vraie si le joueur va avoir la balle, fausse sinon
     */
    public void setAvoirBalle(boolean avoirBalle) {
        this.avoirBalle = avoirBalle;
    }
    /**
     * Mutateur de la tactique
     * @param tactique 
     */
    public void setTactique(int tactique) {
        this.tactique = tactique;
    }
    /**
     * Accesseur de la tortue dans le joueur
     * @return :: la tortue
     */
    public Tortue getTortue() {
        return tortue;
    }
    /**
     * Determiner si le joueur a la balle
     * @return :: la valeur boolean AvoirBalle
     */
    public boolean isAvoirBalle() {
        return avoirBalle;
    }
    /**
     * Accesseur de la tactique
     * @return :: la tactique du joueur
     */
    public int getTactique() {
        return tactique;
    }
    /**
     * Accesseur du role
     * @return :: role de ce joueur
     */
    public int getRole() {
        return role;
    }
    
    /**
     * Etatant donnee une position, le joueur change sa direction en visant la position donnee
     * @param pos :: la position que le joueur doit viser
     */
    public void ChangeDirSelonPos(Position pos){
        if(pos != null){
            int x = pos.getX();
            int y = pos.getY();
            int xOrig = tortue.getPos().getX();
            int yOrig = tortue.getPos().getY();
            double difX = Math.abs(x-xOrig);
            double difY = Math.abs(y-yOrig);
            double diviser = (difY)/(difX);
            int dir = (int) ( Math.toDegrees(Math.atan(diviser)));
            if(difX == 0){
                dir = 0;
                if(y>yOrig)
                dir = 180;
            }
            else if(x>xOrig && y<yOrig){
                dir = 90 - dir;
            }
            else if(x>xOrig && y>yOrig){
                dir = 90 + dir;
            }
            else if(x<xOrig && y<yOrig){
                dir = 270 + dir;
            }
            else if(x<xOrig && y>yOrig){
                dir = 270 - dir;
            }
            tortue.setDir(dir);
        }
    }
    /**
     * Le defenceur se promene seulement devant son enbut
     * Quand la balle procedee par un averse est proche, 
     * il la prend et il la donne quand un coéquipier proche arrive
     */
    public void defense(){
        tortue.avancer(1);
        //Si la balle est tenue par un adversaire et a proximite du but, il prend la balle 
        if(tortue.getPos().getY()>180 && tortue.getPos().getY()<340)
        {
           if(avoirBalle == false && tortue.distanceTortue(balle)<100 && balle.getMaitre().getTortue().getCouleur() != tortue.getCouleur())
               balle.setMaitre(this);
           
        }
        //S'il a la balle, il la donne quand un co-equipier edt a cote
        if(avoirBalle == true)
           {
               for(Joueur j : joueurs){
                   if(j.getTortue().getCouleur()==tortue.getCouleur()&& j!=this && tortue.distanceTortue(j.getTortue())<100)
                   {
                       balle.setMaitre(j);
                       break;
                   }
               }
           }
        if(tortue.getPos().getY() == 25)
        {
            tortue.setDir(180);
        }
        else if(tortue.getPos().getY() == 475)
        {
            tortue.setDir(0);
        }
    }
    /**
     * Action du joueur role 0
     * Tactique 0: Mouvement aleatoire, donne la balle aux ennmies si a proximite
     * Tactique 1: Passe, chercher son co-equipier et passer la balle, ne shoot pas
     * Tactique 2: Attaque directe,avec balle - aller au but, sans balle - movement aleatoire
     */
    public void attaqueLent(){
        switch (tactique)
        {
            case 0:
                if(avoirBalle)
                {
                   mouvementAlea();
                   //Si un adversaire est a cote, donne la balle
                   for(Joueur j : joueurs){
                        if(j.getTortue().getCouleur()!=tortue.getCouleur() && tortue.distanceTortue(j.getTortue())<100)
                        {
                            balle.setMaitre(j);
                            break;
                        }
                    }
                }
                else
                {
                    mouvementAlea();
                }
                break;
            case 1:
                if(avoirBalle){
                   mouvementAlea();
                   //Si le co-equipier est a cote, donne la balle
                   for(Joueur j : joueurs){
                        if(j.getTortue().getCouleur()==tortue.getCouleur() && tortue.distanceTortue(j.getTortue())<100 && j.getRole() ==2)
                        {
                            balle.setMaitre(j);
                            break;
                        }
                    }
                }
                else{
                        mouvementAlea();
                }
                break;
            case 2:
                if(avoirBalle){
                    //Aller au but
                    ChangeDirSelonPos(butPos);
                   tortue.avancer(1);
                   //si deja au but, recommence le mouvement aleatoire
                   if(tortue.getPos().getX()==butPos.getX() && tortue.getPos().getY()==butPos.getY())
                   {
                       this.setTactique(0);
                   }
                   //Si le joueur plus rapide est a cote, donne la balle
                   for(Joueur j : joueurs){
                        if(tortue.distanceTortue(j.getTortue())<100 &&j.getRole() == 2)
                        {
                            balle.setMaitre(j);
                            break;
                        }
                    }
                }
                else{
                    mouvementAlea();
                }
                break;
        }
    }
    /**
     * Action du joueur role 2
     * Tactique 0: Mouvement aleatoire
     * Tactique 1: Passe, chercher son co-equipier et passer la balle
     * Tactique 2: Attaque directe,avec balle - aller au but
     */
    public void attaqueRapide(){
        switch (tactique)
        {
            case 0:
                if(avoirBalle)
                {
                   tortue.avancer(1);
                   mouvementAlea();  
                }
                else
                {
                    mouvementAlea();
                    tortue.avancer(1);
                }
                break;
            case 1:
                if(avoirBalle){
                   mouvementAlea();
                   tortue.avancer(1);
                }
                else{
                    ChangeDirSelonPos(balle.getPos());
                    tortue.avancer(1);
                    tortue.avancer(1);
                }
                break;
            case 2:
                if(avoirBalle)
                {
                    //Aller au but
                   ChangeDirSelonPos(butPos);
                   tortue.avancer(1);
                   tortue.avancer(1);
                   //Si deja au but, recommencer le mouvement aleatoire
                   if(tortue.getPos().getX()==butPos.getX() && tortue.getPos().getY()==butPos.getY())
                   {
                       this.setTactique(0);
                   }
                }
                else
                {
                    //Aller vers la balle
                   ChangeDirSelonPos(balle.getPos());
                   tortue.avancer(1);
                   tortue.avancer(1);
                   int x = balle.getPos().getX();
                   int y = balle.getPos().getY();
                   //Si deja au but, recommencer le mouvement aleatoire
                   if((y<340 && y>180 && x<45) || (y<340 && y>180 && x>720) || 
                           (balle.getMaitre().getRole()==1 && balle.getMaitre().getTortue().getCouleur()!= tortue.getCouleur()) )
                   {
                       this.setTactique(0);
                   }
                }
                break;
        }
    }
    /**
     * Mouvement aleatoire
     */
    public void mouvementAlea(){
        tortue.avancer(1);
        int x = tortue.getPos().getX();
        int y = tortue.getPos().getY();
        //S'il est au bord du terrain, changement de direction
        if(x==25 || y==25 || y==475 ||x==750)
        {
            tortue.setDir((int)(Math.random() * (359-0)));
        }
    }
    /**
     * La fonction principale dans le thread jeu, 
     * chaque joueur joue en fonction de son role
     */
    public void jouer() {
        switch(role)
        {
            case 0:
                attaqueLent();
                break;
            case 1:
                defense();
                break;
            case 2:
                attaqueRapide();
                break;
        }
    }
}
