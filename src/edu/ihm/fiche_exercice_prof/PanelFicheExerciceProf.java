package edu.ihm.fiche_exercice_prof;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel permettant de visualiser la fiche d'un exercice pour un professeur
 * Va utiliser un objet de type Exercice
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelFicheExerciceProf extends JPanel{
	
	public PanelFicheExerciceProf(){
		this.add(new JLabel("FicheExerciceProf"));
		this.add(new JButton("Retour"));
	}

}
