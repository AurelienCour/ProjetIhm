package edu.ihm.construction_exercice;

import edu.ihm.noyau_fonctionnel.Action;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Tentative;
import edu.ihm.noyau_fonctionnel.Utilisateur;

public class ModelConstructionExercice {

	private Utilisateur user;
	private ExerciceRealise exerciceReal;
	private Tentative tentative;

	public ModelConstructionExercice(Utilisateur user, Exercice exercice) {
		this.user = user;
		if(user instanceof Eleve){
			for (ExerciceRealise exoR : ((Eleve) user).getExerciceRealise()) {
				if(exoR.getExerciceFait().equals(exercice)){
					exerciceReal = exoR;
				}
			}
	    	if(exerciceReal == null){
	    		exerciceReal = new ExerciceRealise(exercice);
	    		((Eleve) user).addExerciceRealise(exerciceReal);
	    	}
	    	tentative = new Tentative();
	    	exerciceReal.addTentative(tentative);
		}
	}
	
	public void addActionTentative(String action){
		tentative.addAction(new Action(action));
	}

}
