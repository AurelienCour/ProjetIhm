package com.sdz.Modele;

import java.util.ArrayList;

/**
 * Une classe est un groupement d'élève géré par un professeur
 * @author Groupe8
 * @version 30/03/2017
 */

public class Classes {

	private ArrayList<Exercice> Exercices; //Liste d’exercices à faire pour les élèves de cette classe.
	private ArrayList<Eleve> Eleves; //Liste des élèves qui font partie de la classe.
	
		
	/**
	 * Constructor de la classe Classe.
	 */
	public Classes(){
	}
	
	
	/**
	 * Ajoute un exercice donné à la liste.
	 * @param ex nouvel Exercice
	 */
	public void addExercice(Exercice ex){ 
		
	}
	
	/**
	 *  Supprime un exercice donné de la liste.
	 * @param ex Exercice à supprimer
	 */
	public void suppExercice(Exercice ex){
		
	}
	
	/**
	 * Renvoie les informations de l’exercice donné.
	 * TODO return a voir
	 * @return renvoie le noumero de l'exercice
	 */
	public int getExercice(){
		
		return(0);
	}
	
	/**
	 *  Ajoute un élève donné à la liste.
	 *  (Si au moins une classe =! vide)
	 * @param el nouvel Eleve à ajouter
	 */
	public void addEleve(Eleve el){
		
	}
	
	/**
	 * Supprime un élève donné de la liste si celui ci est présent.
	 * (Si au moins un Eleve)
	 * @param el Eleve à supprimer
	 */
	public void suppEleve(Eleve el){
		
	}
	
	/*
	 * Renvoie les informations de l’eleve donné
	 * TODO return a voir.
	 */
	public Eleve getEleve(){
		return null;
	}
	
	
}
