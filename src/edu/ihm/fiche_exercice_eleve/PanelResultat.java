package edu.ihm.fiche_exercice_eleve;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.ihm.noyau_fonctionnel.ExerciceRealise;

/**
 * Panel permettant de visualiser le résultat d'un exercice évalué
 * Va utiliser un objet de type ExerciceRealise
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelResultat extends JPanel{

	public PanelResultat(ExerciceRealise exerciceR) {
		this.add(new JLabel("RESULTAT"));
	}

}
