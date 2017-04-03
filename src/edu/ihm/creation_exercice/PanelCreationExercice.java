package edu.ihm.creation_exercice;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel contenant les outils necessaire à un professeur pour créer un exercice
 * permet de choisir :
 * 		- une image modèle
 * 		- Le nom de l'exercice
 * 		- Le type d'exercice
 * Va modifier un objet de type Exercice a l'aide d'un ControlerExercice
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelCreationExercice extends JPanel{

	public PanelCreationExercice(){
		this.add(new JLabel("CreationExercice"));
		this.add(new JButton("Retour"));
	}
}
