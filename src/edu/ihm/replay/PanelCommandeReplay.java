package edu.ihm.replay;

import java.awt.Dimension;
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
	
	private JButton lect;
	private JButton actS;
	
	public PanelCommandeReplay(TortueG myTurtle, Tentative tentative){
		this.setLayout(new GridLayout(1,4));
		lect = new JButton("LECTURE");
		ModelReplay model = new ModelReplay(this,myTurtle,tentative);
		lect.setPreferredSize(new Dimension(1, 55));
		lect.addActionListener(new ControlerReplay("lecture",this,model));
		JButton reset = new JButton("MISE A ZERO");
		reset.addActionListener(new ControlerReplay("reset",this,model));
		actS = new JButton("ACTION SUIVANTE");
		actS.addActionListener(new ControlerReplay("suivant",this,model));
		if(tentative.getListeAction().isEmpty()){
			reset.setEnabled(false);
			actS.setEnabled(false);
			lect.setEnabled(false);
		}
		this.add(lect);
		this.add(reset);
		this.add(actS);
	}
	
	public void setBouton(boolean etat1,boolean etat2){
		lect.setEnabled(etat1);
		actS.setEnabled(etat2);
	}
}
