package edu.ihm.liste_exercice_eleve;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel permettant à un élève de voir la liste des Exercices actuels
 * Va utiliser un objet de type Eleve
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelListeExerciceEleve extends JPanel{
	
	public PanelListeExerciceEleve(){
		this.add(new JLabel("ListeExerciceEleve"));
		this.add(new JButton("Retour"));
	}
	
	public static void main (String[] args){
		JFrame test = new JFrame();
		test.add(new PanelListeExerciceEleve());
		test.setVisible(true);
	}

}
