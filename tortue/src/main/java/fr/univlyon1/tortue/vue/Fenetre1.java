/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlyon1.tortue.vue;

import fr.univlyon1.tortue.controleur.Controleur;
import fr.univlyon1.tortue.modele.Joueur;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Emilie
 */
public class Fenetre1 extends JFrame{
    private JPanel panelHaut;
    private final JButton[] buttonsHaut = new JButton[5];
    private final JMenu[] menus = new JMenu[3];
    private JMenuBar menubar;
    private JTextField inputValue;
    private final TortueVue t;
    private final BalleVue b;
    private final TortueVue[] tortueVues = new TortueVue[6];
    private Controleur controleur;
    
    FeuilleDessin feuille;
    /**
     * Constructeur de la fenetre 1
     * @param controleur :: le controleur du programmes
     */
    public Fenetre1(Controleur controleur){
        super("Tortue");
        this.setSize(830, 625);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.controleur = controleur;
        InitMenus();
        InitPanelHaut();
        
        
        
        t = new TortueVue(controleur.getModele().getTortue());
        b = new BalleVue(controleur.getModele().getJeu().getBalle());
       
        associerJouersVues();
        
        feuille = new FeuilleDessin();
        
        getContentPane().add(feuille);
       
        
        feuille.setLayout(null);
        feuille.add(t);
        feuille.add(b);
        for(int j =0; j<6; j++){
            feuille.add(tortueVues[j]);
            tortueVues[j].repaint();
        }
        b.repaint();
        t.repaint();
        feuille.repaint();

        this.setVisible(true);
        
    }
     /**
     * Permet d'ajouter un champ dans un JMenu plus facilement
     * Il suffit de preciser les parametres pour automatiser tout ça.
     * Le ActionListener va être le controleur, pour qu'il puisse donner les ordres
     * au modèle.
     * 
     * @param nom :: Ce qu'il faut écrire dans le champ (quitter, etc)
     * @param menu :: Le JMenu dans lequel il faut insérer ce nouveau champ
     * @param commande :: Ce que le champ doit renvoyer dans le ActionListener
     */
    private void ajouterMenuDansMenuBar(String nom, JMenu menu, String commande){
        JMenuItem nouveauChamp = new JMenuItem(nom);
        menu.add(nouveauChamp);
        nouveauChamp.setActionCommand(commande);
        nouveauChamp.addActionListener(this.controleur);
    }
    /**
     * Initialisation du menu
     */
    private final void InitMenus(){
        menubar = new JMenuBar();
        this.setJMenuBar(menubar);
        menus[0] = new JMenu("File");
        menus[1] = new JMenu("Commande");
        menus[2] = new JMenu("Aide");
        menubar.add(menus[0]);
        menubar.add(menus[1]);
        menubar.add(menus[2]);
        
        ajouterMenuDansMenuBar("Effacer", menus[0], "Effacer");
        ajouterMenuDansMenuBar("Quitter", menus[0], "Quitter");

        ajouterMenuDansMenuBar("Droite", menus[1], "Droite");
        ajouterMenuDansMenuBar("Gauche", menus[1], "Gauche");
        ajouterMenuDansMenuBar("Avancer", menus[1], "Avancer");
        ajouterMenuDansMenuBar("Reculer", menus[1], "Reculer");
        
        ajouterMenuDansMenuBar("Aide", menus[2], "Help");
        ajouterMenuDansMenuBar("A propos", menus[2], "About");
        
        //On rend ce menu visible
        setJMenuBar(menubar);
    }
    /**
     * 
     * @param panel
     * @param b 
     */
    private void ajouterBouttonDansPanel(JPanel panel, JButton b){
        panel.add(b);
        b.addActionListener(this.controleur);
    }
    /**
     * 
     */
    private void InitPanelHaut(){
        panelHaut = new JPanel(new GridLayout());
        getContentPane().add(panelHaut,"North");
        buttonsHaut[0] = new JButton("Effacer");
        buttonsHaut[1] = new JButton("Droite");
        buttonsHaut[2] = new JButton("Gauche");
        buttonsHaut[3] = new JButton("Avancer");
        buttonsHaut[4] = new JButton("Reculer");
        
        ajouterBouttonDansPanel(panelHaut,buttonsHaut[0]);
        inputValue = new JTextField("25",4);
        inputValue.addActionListener(controleur);
        
        
        panelHaut.add(inputValue);
        for(int i=1;i< buttonsHaut.length;i++){
           ajouterBouttonDansPanel(panelHaut,buttonsHaut[i]);
        }
      
        
    }
    
    /**
     * Chaque Tortuevue est associee avec un joueur
     */
    private void associerJouersVues(){
        Joueur[] liste = controleur.getModele().getJeu().getBleu().getJoueurs();
        int i =0;
        for(Joueur j : liste){
            tortueVues[i] = new TortueVue(j.getTortue());
            i++;
        }
        liste = controleur.getModele().getJeu().getRose().getJoueurs();
        for(Joueur j : liste){
            tortueVues[i] = new TortueVue(j.getTortue());
            i++;
        }
    }
    
}
