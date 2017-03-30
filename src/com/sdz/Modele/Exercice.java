package com.sdz.Modele;

import java.net.URL;

/**
 * Cette classe représente les exercices que doivent effectuer les élèves.
 * Les exercices sont regroupés par noms et types. Ils sont listés dans la classe Classe
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
	private String TypeExercice;
	
	/**
	 * le modèle est une image. Cette image représente l’exercice que doit réaliser les enfants.

	 */
	private URL Modele;
	
	/**
	 * Constructor de la classe Exercice
	 * @param nomExercice
	 * @param TypeExercice
	 * @param modele
	 */
	public Exercice(String nomExercice, String TypeExercice, URL modele){
		
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
	 * @return
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
	 * @return
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
