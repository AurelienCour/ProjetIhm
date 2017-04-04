package edu.ihm.noyau_fonctionnel;

import java.net.URL;

/**
 * Cette classe représente les exercices que doivent effectuer les élèves.
 * Les exercices sont regroupés par noms et types. Ils sont listés dans la classe Classe.
 * @author Erwan MAZUREAU
 * @version 03/04/2017
 */
public class Exercice {
	
	/**
	 * Nom de l’exercice que les élèves doivent réaliser.
	 */
	private String nomExercice;  
	
	/**
	 * cela représente le type de l’exercice. Le type est de trois types différents : une tortue générale, une tortue rapide et une rapide traçant en plusieurs couleurs.
	 */
	private String typeExercice;
	
	/**
	 * le modèle est une image. Cette image représente l’exercice que doit réaliser les enfants.
	 */
	private URL modele;
	
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
	public Exercice(String nomExercice, String typeExercice, String modele){
		this.nomExercice = nomExercice;
		this.typeExercice = typeExercice;
		this.modele = Exercice.class.getResource(modele);
	}
	
	/**
	 * Getter du nom
	 * @return Nom de l'exercice
	 */
	public String getNomEx(){
		return this.nomExercice;
	}
	
	/**
	 * Permet de modifier le nom de l’exercice
	 * @param nom Nouveau nom de l'exercice
	 */
	public void setNomEx(String nomEx){
		this.nomExercice = nomEx;
	}
	/**
	 * Renvoie le type d’exercice
	 * @return Le type d'exercice
	 */
	public String getTypeEx(){
		return this.typeExercice;		
	}
	
	/**
	 *  Permet de modifier le type de l’exercice
	 * @param type Type de la tortue (Rapide, couleur,normal)
	 */
	public void setTypeEx(String typeEx){
		this.typeExercice = typeEx;
	}
	/**
	 * Renvoie le modèle de l'exercice.
	 * @return Permet de récupérer le lien d'acces au modèle
	 */
	public URL getModele(){
		return this.modele;
	}
	
	/**
	 * Permet de modifier l’image de l’exercice.
	 * @param modele URL du nouveau modele de l'exercice
	 */
	public void setModele(String newUrl){
		this.modele = Exercice.class.getResource(newUrl);
	}
	
}
