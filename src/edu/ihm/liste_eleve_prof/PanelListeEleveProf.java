package edu.ihm.liste_eleve_prof;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel permettant à un professeur de visualiser la liste des élèves
 * Va utiliser un objet de type Classe
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelListeEleveProf extends JPanel{
	
	public PanelListeEleveProf(){
		this.add(new JLabel("ListeEleveProf"));
		this.add(new JButton("Retour"));
	}

}
