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
import edu.ihm.fiche_exercice_prof.PanelFicheExerciceProf;
import edu.ihm.liste_eleve_prof.PanelListeEleveProf;
import edu.ihm.liste_exercice_eleve.PanelListeExerciceEleve;
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
public class AcceuilProf extends Acceuil{
	
	private JPanel panelInfo;
	
	public AcceuilProf (Professeur user){
		super(user);
		panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout());
		goListeEleve();
		this.add(panelInfo,BorderLayout.CENTER);
	}
	
	public void goListeEleve(){
		panelInfo.removeAll();
		panelInfo.add(new PanelListeEleveProf(this));
		panelInfo.revalidate();
	}

	public void goFicheEleve(Eleve eleve){
		panelInfo.removeAll();
		panelInfo.add(new PanelFicheEnfantProf(eleve));
		panelInfo.revalidate();
	}
	
	public void goFicheExercice(Exercice exercice){
		panelInfo.removeAll();
		panelInfo.add(new PanelFicheExerciceProf(exercice,(Professeur) this.getUser()));
		panelInfo.revalidate();
	}

}
