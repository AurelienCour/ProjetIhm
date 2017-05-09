package edu.ihm.construction_exercice;

import edu.ihm.acceuil.Acceuil;
import edu.ihm.acceuil.AcceuilEleve;
import edu.ihm.noyau_fonctionnel.Action;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Tentative;
import edu.ihm.noyau_fonctionnel.Utilisateur;

public class ModelConstructionExercice {

	private Utilisateur user;
	private Exercice exercice;
	private Tentative tentative;
	private Action lastAction;

	public ModelConstructionExercice(Utilisateur user, Exercice exercice) {
		this.user = user;
		this.exercice = exercice;
		tentative = new Tentative();
	}
	
	public void addActionTentative(String action){
		lastAction = new Action(action);
		tentative.addAction(lastAction);
	}
	
	public void removeLastAction(){
		if(lastAction != null){
			tentative.removeAction(lastAction);
			lastAction = null;
		}
	}
	
	public void finExercice(Acceuil acceuil){
		ExerciceRealise exerciceReal = null;
		if(user instanceof Eleve){
			AcceuilEleve trans = (AcceuilEleve) acceuil;
			for (ExerciceRealise exoR : ((Eleve) user).getExerciceRealise()) {
				if(exoR.getExerciceFait().equals(exercice)){
					exerciceReal = exoR;
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
	
	public Tentative getTentative(){
		return tentative;
	}

}
