package edu.ihm.replay;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel composer de toutes les commandes utilisées pour la visualisation d'une tentative
 * Va utiliser l'objet ExerciceRealise
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelCommandeReplay extends JPanel{
	
	public PanelCommandeReplay(){
		this.setLayout(new GridLayout(1,4));
		this.add(new JButton("LECTURE"));
		this.add(new JButton("PAUSE"));
		this.add(new JButton("ACTION SUIVANTE"));
		this.add(new JButton("RETOUR"));
	}

}
