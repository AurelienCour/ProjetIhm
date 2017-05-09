package edu.ihm.fiche_exercice_eleve;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ihm.acceuil.AcceuilEleve;
import edu.ihm.construction_exercice.ConstructionExercice;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Tentative;

public class ControlerPanelFicheExerciceEleve implements ActionListener {
	
	private Exercice exercice;
	private ExerciceRealise exoR;
	private Eleve user;
	private AcceuilEleve acceuilEleve;
	private Tentative tentative;

	public ControlerPanelFicheExerciceEleve(Exercice exercice, Eleve user, AcceuilEleve acceuilEleve) {
		this.exercice = exercice;
		this.user = user;
		this.acceuilEleve = acceuilEleve;
	}

	public ControlerPanelFicheExerciceEleve(ExerciceRealise exoR, Tentative tenta) {
		this.tentative = tenta;
		this.exoR = exoR;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(tentative != null){
			new ConstructionExercice(tentative,exoR);
		}
		else
			new ConstructionExercice(user, exercice,acceuilEleve);
	}

}
