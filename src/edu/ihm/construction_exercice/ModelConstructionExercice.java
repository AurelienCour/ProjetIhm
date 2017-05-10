package edu.ihm.construction_exercice;

import edu.ihm.acceuil.Acceuil;
import edu.ihm.acceuil.AcceuilEleve;
import edu.ihm.noyau_fonctionnel.Action;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Tentative;
import edu.ihm.noyau_fonctionnel.Utilisateur;

/**
 * Le model de la classe construction exercice
 * @author Aurelien
 *
 */
public class ModelConstructionExercice {

	private Utilisateur user; // L'utilisateur connecté
	private Exercice exercice; // L'exercice visualisé, résolu ou corrigé
	private Tentative tentative; // La tentative en cas de visualisation
	private Action lastAction; // La dernière action effectué pendant la résolution

	/**
	 * Le constructeur de la class
	 * @param user L'utilisateur connecté
	 * @param exercice  L'exercice visualisé
	 */
	public ModelConstructionExercice(Utilisateur user, Exercice exercice) {
		this.user = user;
		this.exercice = exercice;
		tentative = new Tentative();
	}
	
	/**
	 * Permet d'ajouter une action à la tentative
	 * @param action L'action à ajouter
	 */
	public void addActionTentative(String action){
		lastAction = new Action(action);
		tentative.addAction(lastAction);
	}
	
	/**
	 * Permet d'enlever la dernière action de la tentative
	 */
	public void removeLastAction(){
		if(lastAction != null){
			tentative.removeAction(lastAction);
			lastAction = null;
		}
	}
	
	/**
	 * Permet d'ajouter la tentative à l'exercice ou l'exercice realisé
	 * @param acceuil l'acceuil de l'application
	 */
	public void finExercice(Acceuil acceuil){
		ExerciceRealise exerciceReal = null;
		if(user instanceof Eleve){
			AcceuilEleve trans = (AcceuilEleve) acceuil;
			for (ExerciceRealise exoR : ((Eleve) user).getExerciceRealise()) {
				if(exoR.getExerciceFait().equals(exercice)){
					exerciceReal = exoR;
					if(exoR.isCorrect()){
						exoR.setCorrect(false);
					}
				}
			}
	    	if(exerciceReal == null){
	    		exerciceReal = new ExerciceRealise(exercice);
	    		((Eleve) user).addExerciceRealise(exerciceReal);
	    	}
	    	exerciceReal.addTentative(tentative);
	    	trans.goFicheExercice(exerciceReal.getExerciceFait());
		}
	}
	
	/**
	 * Permet de récupérer la tentative du model
	 * @return La tentative effectué
	 */
	public Tentative getTentative(){
		return tentative;
	}

}
