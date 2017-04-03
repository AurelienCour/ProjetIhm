package edu.ihm.acceuil;


import java.awt.BorderLayout;

import javax.swing.JFrame;

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
		
		this.add(new PanelMenu(),BorderLayout.WEST);
	}

}
