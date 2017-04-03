package edu.ihm.acceuil;


import java.awt.BorderLayout;

import javax.swing.JFrame;

import edu.ihm.menu.PanelMenu;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.Professeur;
import edu.ihm.noyau_fonctionnel.Utilisateur;

/**
 * La Jframe principal de l'application
 * Permet la visualisation du menu et de la fenetre principal changeant en fonction du type d'utilisateur
 * @author Groupe8
 * @version 30/03/2017
 */
public class Acceuil extends JFrame{
	
	private Utilisateur user;
	
	public Acceuil (Utilisateur user){
		this.user = user;
		this.setLayout(new BorderLayout());
		
		this.add(new PanelMenu(user).getJTree(),BorderLayout.WEST);
		
		this.setVisible(true);
		this.pack();
	}
	
	public static void main (String[] args){
		Professeur p = new Professeur("toto", "titi", "Girard", "Patrick");
		Classes c1 = new Classes("CE1");
		Eleve e1 = new Eleve("hehe", "hihi", "Conrady", "marin", c1, null);
		Exercice ex1 = new Exercice("ExerciceTest", "TortueG", null);
		c1.addExercice(ex1);
		c1.addEleve(e1);
		p.addClasses(c1);
		Acceuil a = new Acceuil(p);
	}

}
