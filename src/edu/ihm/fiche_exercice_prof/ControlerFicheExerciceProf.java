package edu.ihm.fiche_exercice_prof;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ihm.construction_exercice.ConstructionExercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;

public class ControlerFicheExerciceProf implements ActionListener {

	private ExerciceRealise exoR;
	private String idButton;

	public ControlerFicheExerciceProf(ExerciceRealise exoR, String idButton) {
		this.exoR = exoR;
		this.idButton = idButton;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(idButton.equals("Voir"))
			new ConstructionExercice(exoR,true);
		else
			new ConstructionExercice(exoR,false);
	}

}
