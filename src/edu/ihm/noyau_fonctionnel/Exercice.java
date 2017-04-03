package edu.ihm.noyau_fonctionnel;

import java.net.URL;

/**
 * Cette classe représente les exercices que doivent effectuer les élèves.
 * Les exercices sont regroupés par noms et types. Ils sont listés dans la classe Classe.
 * @author Groupe8
 * @version 30/03/2017
 */
public class Exercice {
	
	/**
	 * Nom de l’exercice que les élèves doivent réaliser.
	 */
	private String NomExercice;  
	
	/**
	 * cela représente le type de l’exercice. Le type est de trois types différents : une tortue générale, une tortue rapide et une rapide traçant en plusieurs couleurs.
	 */
	private String typeExercice;
	
	/**
	 * le modèle est une image. Cette image représente l’exercice que doit réaliser les enfants.

	 */
	private URL Modele;
	
	/**
	 * Constructeur de la classe Exercice
	 * prend en paramètres 2 attributs de type String,
	 * si null alors on initialise avec les valeurs "Exercice 0" pour nomExercice
	 * et "Tortue normale" pour typeExercice,
	 * et un attributs de type URL, possiblement null.
	 * @param nomExercice : le nom de l'Exercice
	 * @param TypeExercice : le type d'exercice
	 * @param modele : le modele de l'exercice
	 */
	public Exercice(String nomExercice, String typeExercice, URL modele){
		
	}
	
	/**
	 * Getter du nom
	 * @return Nom de l'exercice
	 */
	public String getNom(){
		return null;
	}
	
	/**
	 * Permet de modifier le nom de l’exercice
	 * @param nom Nouveau nom de l'exercice
	 */
	public void setNom(String nom){
		
	}
	/**
	 * Renvoie le type d’exercice
	 * @return Le type d'exercice
	 */
	public String getType(){
		return null;
		
	}
	
	/**
	 *  Permet de modifier le type de l’exercice
	 * @param type Type de la tortue (Rapide, couleur,normal)
	 */
	public void setType(String type){
		
	}
	/**
	 * Renvoie le modèle de l'exercice.
	 * @return Permet de récupérer le lien d'acces au modèle
	 */
	public URL getModele(){
		return null;
		
	}
	
	/**
	 * Permet de modifier l’image de l’exercice.
	 * @param modele URL du nouveau modele de l'exercice
	 */
	public void setModele(URL modele){
		
	}
	
}
