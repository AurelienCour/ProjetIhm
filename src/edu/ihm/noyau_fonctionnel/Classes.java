package edu.ihm.noyau_fonctionnel;

import java.util.ArrayList;

/**
 * Une classe est un groupement d eleves gerees par un professeur
 * @author MathiasAntunes
 * @version 30/03/2017
 */

public class Classes {

	private ArrayList<Exercice> Exercices; //Liste d exercices à faire pour les eleves de cette classe.
	private ArrayList<Eleve> Eleves; //Liste des eleves qui font partie de la classe. 
	
		
	/**
	 * Constructeur de la classe Classe.
	 */
	public Classes(){
	}
	
	
	/**
	 * Ajoute un exercice donne a la liste.
	 * Un exercice ne peut etre ajoute qu a une liste deja presente. 
	 * Un exercie peut etre ajout� a une classe vide
	 * Seul un exercice peut etre ajoute a cette liste.
	 * Message d'erreur si ajout d un exercice dans une liste non existente.
	 * @param ex nouvel Exercice
	 */
	public void addExercice(Exercice ex){ 
		
	}
	
	
	/**
	 *  Supprime un exercice donne de la liste.
	 *  Un exercice ne peut etre supprimer que si l exercice existe.
	 *  Un exercice doit etre present dans la liste.
	 *  Si exercice non present. Un message d'erreur est envoy�.
	 * @param ex Exercice a� supprimer
	 */
	public void suppExercice(Exercice ex){
		
	}
	
	
	/**
	 * Renvoie les informations de l exercice donne.
	 * TODO return a voir
	 * @return renvoie le numero de l'exercice
	 */
	public int getExercice(){
		
		return(0);
	}
	
	
	/**
	 * Ajoute un eleve donne a la liste.
	 * (Si au moins une classe =! vide)
	 * Un eleve ne peut etre ajoute qu a une liste deja presente. 
	 * Un eleve peut etre ajoute a une classe vide.
	 * Seul un eleve peut etre ajoute a cette liste.
	 * Message d'erreur si ajout d un eleve dans une liste non existente.
	 * Un eleve ne peut etre ajoute deux fois dans la meme liste.
	 * Un eleve appartient a une seule classe.
	 * @param el nouvel Eleve a ajouter
	 */
	public void addEleve(Eleve el){
		
	}
	
	
	/**
	 * Supprime un eleve donne de la liste si celui ci est present.
	 * (Si au moins un Eleve)
	 * Un eleve ne peut etre supprimer que si l eleve existe.
	 * Un eleve doit etre present dans la liste.
	 * Si eleve non present. Un message d'erreur est envoy�.
	 * @param el Eleve a supprimer
	 */
	public void suppEleve(Eleve el){
		
	}
	
	/**
	 * Accesseur de l'attribut Eleve.
	 * Renvoie les informations de l élève donné.
	 * TODO return a voir.
	 */
	public Eleve getEleve(){
		return null;
	}
	
	
}
