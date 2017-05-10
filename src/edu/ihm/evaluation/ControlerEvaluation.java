package edu.ihm.evaluation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe permettant la gestion des intéraction sur le panel Evaluation
 * @author Aurelien
 *
 */
public class ControlerEvaluation implements ActionListener {
	
	private PanelEvaluation panelEvaluation; // Le panel controlé

	/**
	 * Le constructeur de notre class
	 * @param panelEvaluation Le panel controlé
	 */
	public ControlerEvaluation(PanelEvaluation panelEvaluation) {
		this.panelEvaluation = panelEvaluation;
	}

	/**
	 * Permet la gestion des intéraction avec le bouton
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		panelEvaluation.correct();
	}

}
