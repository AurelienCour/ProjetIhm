package edu.ihm.noyau_fonctionnel;

import java.util.ArrayList;

/**
 * Classe héritant de la classe Utilisateur. Cette classe représente un enseignant, qui gère des classes
 * @author AurelienCourtillat
 * @version 30/03/2017
 */
public class Professeur extends Utilisateur{

	private ArrayList<Classes> classes; // Les classe que le professeur gère

	/**
	 * Constructeur de la classe Professeur
	 * @param identifiant	L'identifiant de l'utilisateur
	 * @param motDePasse	Le mot de passe de l'utilisateur
	 * @param nom			Le nom de l'utilisateur
	 * @param prenom		Le prenom de l'utilisateur
	 */
	public Professeur(String identifiant, String motDePasse, String nom, String prenom) {
		super(identifiant, motDePasse, nom, prenom);
	}

	/**
	 * Permet de récupérer la liste des classes du professeur
	 * @return La liste des classes du professeur
	 */
	public ArrayList<Classes> getClasses() {
		return classes;
	}

	/**
	 * Fonction permettant d'ajouter une classe a la liste des classes du professeur
	 * si lla classe n'est pas déja dans la liste
	 * @param e La classe à ajouter
	 * @return true si la classe à été ajouter
	 */
	public boolean addClasses(Classes e) {
		return classes.add(e);
	}

	/**
	 * Fonction permettant de savoir si la liste de classe est vide
	 * @return true si la liste est vide
	 */
	public boolean isEmpty() {
		return classes.isEmpty();
	}

	/**
	 * Fonction permettant de retirer une classe de la liste
	 * @param e La classe a retirer
	 * @return true si la classe à été retirée
	 */
	public boolean removeClasses(Classes e) {
		return classes.remove(e);
	}

	

	
	
}
