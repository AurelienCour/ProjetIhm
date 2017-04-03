package edu.ihm.liste_exercice_prof;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel de visualisation des Exercices pour un professeur
 * Affiche une liste des Exercices pour une classe donnée
 * Va utiliser un objet de type professeur
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelExerciceProf extends JPanel{
	
	public PanelExerciceProf(){
		JLabel test = new JLabel("ExerciceProf");
		this.add(test);
		this.add(new JButton("Retour"));
	}
}
