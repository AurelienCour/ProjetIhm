package edu.ihm.replay;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.ihm.noyau_fonctionnel.Tentative;
import edu.ihm.tortue.TortueCouleur;
import edu.ihm.tortue.TortueG;
import edu.ihm.tortue.TortueRapide;

/**
 * Panel composer de toutes les commandes utilisées pour la visualisation d'une tentative
 * Va utiliser l'objet ExerciceRealise
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelCommandeReplay extends JPanel{
	
	public PanelCommandeReplay(TortueG myTurtle, Tentative tentative){
		this.setLayout(new GridLayout(1,4));
		JButton lect = new JButton("LECTURE");
		lect.addActionListener(new ControlerReplay(myTurtle,tentative,"lecture"));
		JButton pause = new JButton("PAUSE");
		JButton actS = new JButton("ACTION SUIVANTE");
		JButton ret = new JButton("RETOUR");
		
		this.add(lect);
		this.add(pause);
		this.add(actS);
		this.add(ret);
	}

}
