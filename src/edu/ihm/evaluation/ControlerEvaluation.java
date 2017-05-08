package edu.ihm.evaluation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlerEvaluation implements ActionListener {
	
	private PanelEvaluation panelEvaluation;

	public ControlerEvaluation(PanelEvaluation panelEvaluation) {
		this.panelEvaluation = panelEvaluation;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		panelEvaluation.correct();
	}

}
