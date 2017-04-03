package edu.ihm.evaluation;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Le panel permettant à un professeur d'évaluer la dernière tentative d'un élève
 * pour un exercice donné
 * Modifie la classe ExerciceRealise a l'aide du ControlerExercice
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelEvaluation extends JPanel{
	
	public PanelEvaluation(){
		this.add(new JLabel("Evaluation"));
		this.add(new JButton("Retour"));
	}

}
