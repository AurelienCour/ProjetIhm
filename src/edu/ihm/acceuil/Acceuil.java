package edu.ihm.acceuil;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import edu.ihm.liste_eleve_prof.PanelListeEleveProf;
import edu.ihm.liste_exercice_eleve.PanelListeExerciceEleve;
import edu.ihm.menu.PanelMenu;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Professeur;
import edu.ihm.noyau_fonctionnel.Utilisateur;
import etu.ihm.Main.Database;

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
		JScrollPane j = new JScrollPane(new PanelMenu(user).getJTree());
		this.add(j,BorderLayout.WEST);
		if(this.user instanceof Professeur){
			this.add(new PanelListeEleveProf(),BorderLayout.CENTER);
		}
		else if(this.user instanceof Eleve){
			this.add(new PanelListeExerciceEleve(),BorderLayout.CENTER);
		}
		this.setVisible(true);
		this.setSize(new Dimension(500,500));
	}

}
