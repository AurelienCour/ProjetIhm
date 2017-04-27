package edu.ihm.fiche_exercice_eleve;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ihm.construction_exercice.ConstructionExercice;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;

public class ControlerPanelFicheExerciceEleve implements ActionListener {
	
	private Exercice exercice;
	private Eleve user;

	public ControlerPanelFicheExerciceEleve(Exercice exercice, Eleve user) {
		this.exercice = exercice;
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new ConstructionExercice(user, exercice);
	}

}
