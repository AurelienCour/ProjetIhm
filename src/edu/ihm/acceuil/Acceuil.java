package edu.ihm.acceuil;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;

import edu.ihm.database.Database;
import edu.ihm.menu.PanelMenu;
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(user.getNom());
		this.add(new PanelMenu(user).getJTree(),BorderLayout.WEST);
		
		this.setVisible(true);
		this.setSize(new Dimension(300,300));
	}
	
	
	public static void main (String[] args){
		
		Database db = new Database();
		//db.peuplement();
		db.chargementDonnees();
		Map<String,Object> professeurs = db.getProfesseur();
		Map<String,Object> eleves = db.getEleves();
		int i = 0;
		for(Entry<String, Object> entry2 : professeurs.entrySet()) {
			Professeur test = (Professeur) entry2.getValue();
			//Eleve test = (Eleve) entry2.getValue();
			Acceuil a = new Acceuil(test);
		}
	}

}
