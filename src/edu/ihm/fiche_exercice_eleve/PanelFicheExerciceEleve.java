package edu.ihm.fiche_exercice_eleve;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel permettant à un eleve de visualiser la fiche d'un exercice
 * Va utiliser un objet de type Exercice
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelFicheExerciceEleve extends JPanel{
	
	public PanelFicheExerciceEleve(){
		this.add(new JLabel("FicheExerciceEleve"));
		this.add(new JButton("Retour"));
	}

}
