package edu.ihm.acceuil;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import edu.ihm.fiche_enfant_prof.PanelFicheEnfantProf;
import edu.ihm.liste_eleve_prof.PanelListeEleveProf;
import edu.ihm.liste_exercice_eleve.PanelListeExerciceEleve;
import edu.ihm.menu.PanelMenu;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Professeur;
import edu.ihm.noyau_fonctionnel.Utilisateur;

/**
 * La Jframe principal de l'application
 * Permet la visualisation du menu et de la fenetre principal changeant en fonction du type d'utilisateur
 * @author Groupe8
 * @version 30/03/2017
 */
public class AcceuilProf extends JFrame{
	
	private Utilisateur user;
	private JPanel panelInfo;
	
	public AcceuilProf (Utilisateur user){
		this.user = user;
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(user.getNom());
		JScrollPane j = new JScrollPane(new PanelMenu(user).getJTree());
		this.add(j,BorderLayout.WEST);
		panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout());
		if(this.user instanceof Professeur){
			panelInfo.add(new PanelListeEleveProf(this));
			this.add(panelInfo,BorderLayout.CENTER);
		}
		else if(this.user instanceof Eleve){
			this.add(new PanelListeExerciceEleve(),BorderLayout.CENTER);
		}
		this.setVisible(true);
		this.setSize(new Dimension(500,500));
	}
	
	public Utilisateur getUser(){
		return this.user;
	}
	
	public void goFicheEleve(Eleve eleve){
		panelInfo.removeAll();
		panelInfo.add(new PanelFicheEnfantProf(eleve));
		panelInfo.revalidate();
	}

}
