package com.sdz.Modele;

import java.util.ArrayList;

/**
 * Une classe est un groupement dâ€™Ã©lÃ¨ve gÃ©rÃ© par un professeur
 * @author Groupe8
 * @version 30/03/2017
 */

/*. Attributs :
Exercices : ArrayList<Exercice> → Liste d’exercices à faire pour les élèves de cette classe.
Eleves : ArrayList<Eleve> → Liste des élèves qui font partie de la classe.
c. Méthodes :
Classe() → Constructor de la classe Classe
void addExercice(Exercice) : Ajoute un exercice donné à la liste.
void suppExercice(Exercice) : Supprime un exercice donné de la liste.
integer getExercice(Id) : Renvoie les informations de l’exercice donné.
void addEleve(Eleve) : Ajoute un élève donné à la liste.(Si au moins une classe =! vide)
suppEleve(Eleve) : Supprime un élève donné de la liste si celui ci est présent.(Si au moins un Eleve)
Eleve getEleve(Eleve) : Renvoie les informations de l’eleve donné.*/

public class Classes {

	private ArrayList<Exercice> Exercices;
	private ArrayList<Eleve> Eleves;
	
	
	
	public void addExercice(Exercice ex){
		
	}
	
	public void suppExercice(Exercice ex){
		
	}
	
	public int getExercice(){
		
		return(0);
	}
	
	public void addEleve(Eleve el){
		
	}
	
	public void suppEleve(Eleve el){
		
	}
	
	public Eleve getEleve(){
		return null;
		
		
		
		
	}
	
	
}
