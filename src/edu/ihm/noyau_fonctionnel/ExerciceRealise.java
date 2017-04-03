package edu.ihm.noyau_fonctionnel;

import java.util.ArrayList;

/**
 * Cette classe correspond aux exercice complété par les Eleves.
 * Ces exercices pourront par la suite être évulaué par le professeur
 * @author AurelienCourtillat
 * @version 30/03/2017
 */
public class ExerciceRealise {

	private ArrayList<Tentative> listeTentatives; // la liste des tentatives effectué sur l'exercice
	private boolean correct;	// Booleen permettant de savoir si l'exercice à été corrigé
	private Evaluation resultat;	// L'évaluation de l'exercice si elle a été corrigé
	private Exercice exerciceFait;	// L'exercice qui a été effectué
	
	/**
	 * Constructeur de la classe ExerciceRealise
	 * @param exerciceFait L'exercice qui a été réalisé
	 */
	public ExerciceRealise(Exercice exerciceFait) {
		this.exerciceFait = exerciceFait;
	}

	/**
	 * Permet de récupérer la liste des tentatives.
	 * @return La liste des tentatives
	 */
	public ArrayList<Tentative> getListeTentatives() {
		return listeTentatives;
	}

	/**
	 * permet de savoir si l'exercice à été corrigé
	 * Callable si un exercice
	 * @return true si l'exercice à été corrigé
	 */
	public boolean isCorrect() {
		return correct;
	}

	/**
	 * Permet de dire si l'exercice à été corrigé ou non
	 * @param correct true si l'exercice à été corrigé
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	/**
	 * Permet de récupérer l'evaluation si l'exercice est corrigé
	 * retourne null si il n'est pas corriger
	 * @return L'evaluation si l'exercice est corrigé, null sinon
	 */
	public Evaluation getResultat() {
		return resultat;
	}

	/**
	 * Permet de modifier l'évaluation d'un exercice
	 * met le booleen correct a true si il ne l'est pas déja
	 * @param resultat L'evaluation de l'exercice
	 */
	public void corriger(Evaluation resultat) {
		this.resultat = resultat;
	}

	/**
	 * permet de récupérer l'exercice qui a été effectué
	 * @return L'exercice effectué
	 */
	public Exercice getExerciceFait() {
		return exerciceFait;
	}

	/**
	 * Permet de rajouter un tentative a la liste si cette derniere n'est pas présente
	 * @param e la tentative à ajouter
	 * 
	 * @return true si la tentative a été ajouté
	 */
	public boolean addTentative(Tentative e) {
		return listeTentatives.add(e);
	}

	/**
	 * Permet de savoir si la liste des tentatives est vide ou non
	 * @return true si la liste est vide
	 */
	public boolean isEmpty() {
		return listeTentatives.isEmpty();
	}

}
