package edu.ihm.fiche_exercice_prof;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.construction_exercice.ConstructionExercice;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;

/**
 * Le controler permettant de gérer les intéraction avec la fiche d'exercice du prof
 * @author Aurelien
 *
 */
public class ControlerFicheExerciceProf implements ActionListener {

	private ExerciceRealise exoR; // L'exercice réalisé à corriger
	private Exercice exo; // L'exercice dont on a les informations
	private String idButton; // L'id permettant de connaitre le bouton sélectionné
	private AcceuilProf acceuilProf; // L'acceuil pour la redirection

	/**
	 * Le constructeur de la classe permettant la correction d'un exercice réalisé
	 * @param exoR L'exercice à corriger
	 * @param idButton L'id du bouton
	 * @param acceuilProf L'acceuil pour la redirection
	 */
	public ControlerFicheExerciceProf(ExerciceRealise exoR, String idButton, AcceuilProf acceuilProf) {
		this.exoR = exoR;
		this.idButton = idButton;
		this.acceuilProf = acceuilProf;
	}
	
	/**
	 * Le constructeur de la classe permettant la modification d'un exercice 
	 * @param exo L'exercice a modifié
	 * @param idButton L'id du bouton
	 * @param acceuilProf L'acceuil pour la redirection
	 */
	public ControlerFicheExerciceProf(Exercice exo, String idButton, AcceuilProf acceuilProf) {
		this.exo = exo;
		this.idButton = idButton;
		this.acceuilProf = acceuilProf;
	}

	/**
	 * La fonction permettant la gestion des intéraction avec les boutons
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(idButton.equals("Voir"))
			new ConstructionExercice(exoR,true,acceuilProf);
		else if(idButton.equals("Corriger"))
			new ConstructionExercice(exoR,false,acceuilProf);
		else
			acceuilProf.goModificationExercice(exo);
	}

}
