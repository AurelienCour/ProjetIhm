package edu.ihm.fiche_exercice_eleve;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ihm.acceuil.AcceuilEleve;
import edu.ihm.construction_exercice.ConstructionExercice;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Tentative;

/**
 * La classe permettant de gérer les intéraction avec la fiche d'exercice
 * @author Aurelien
 *
 */
public class ControlerPanelFicheExerciceEleve implements ActionListener {
	
	private Exercice exercice; // L'exercice dont on souhaite les informations
	private ExerciceRealise exoR; // L'exercice réalisé
	private Eleve user; // L'élève ayant fait les exercices
	private AcceuilEleve acceuilEleve; // L'acceuil pour la redirection
	private Tentative tentative; // La tentative selectionné

	/**
	 * Le constructeur de la classe pour controler l'intéraction avec le bouton faire
	 * @param exercice L'exercice a faire
	 * @param user L'utilisateur faisant l'exercice
	 * @param acceuilEleve L'acceuil pour la redirection
	 */
	public ControlerPanelFicheExerciceEleve(Exercice exercice, Eleve user, AcceuilEleve acceuilEleve) {
		this.exercice = exercice;
		this.user = user;
		this.acceuilEleve = acceuilEleve;
	}

	/**
	 * Constructeur de la classe pour la visualisation d'une tentative
	 * @param exoR L'exercice réalisé
	 * @param tenta La tentative a visualisé
	 */
	public ControlerPanelFicheExerciceEleve(ExerciceRealise exoR, Tentative tenta) {
		this.tentative = tenta;
		this.exoR = exoR;
	}

	/**
	 * Fonction permettant la gestion des intéractions avec les différents boutons
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(tentative != null){
			new ConstructionExercice(tentative,exoR);
		}
		else
			new ConstructionExercice(user, exercice,acceuilEleve);
	}

}
