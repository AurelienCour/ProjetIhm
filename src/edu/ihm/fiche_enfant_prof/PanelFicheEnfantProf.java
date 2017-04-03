package edu.ihm.fiche_enfant_prof;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel de visualisation de la fiche d'un enfant
 * Va utiliser un objet de type Eleve
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelFicheEnfantProf extends JPanel{
	
	public PanelFicheEnfantProf(){
		this.add(new JLabel("FicheEnfantProf"));
		this.add(new JButton("Retour"));
	}

}
