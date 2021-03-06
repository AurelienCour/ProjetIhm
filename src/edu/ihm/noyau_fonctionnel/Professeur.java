package edu.ihm.noyau_fonctionnel;

import java.util.ArrayList;

/**
 * Classe heritant de la classe Utilisateur. Cette classe represente un enseignant, qui gere des classes
 * @author AurelienCourtillat 
 * @version 30/03/2017 
 */
public class Professeur extends Utilisateur{

	private ArrayList<Classes> classes; // Les classe que le professeur gere

	/**
	 * Constructeur de la classe Professeur
	 * @param identifiant	L'identifiant de l'utilisateur (login)
	 * @param motDePasse	Le mot de passe de l'utilisateur
	 * @param nom			Le nom de l'utilisateur
	 * @param prenom		Le prenom de l'utilisateur
	 * Si nom et prenom du professeur sont vides,  message d erreur
	 * Si mot de passe vide, message d erreur
	 * Si indentifiant vide,  message d erreur
	 * Tous les champs vides envoient un message d erreur
	 */
	public Professeur(String identifiant, String motDePasse, String nom, String prenom) {
		super(identifiant, motDePasse, nom, prenom);
		this.classes = new ArrayList<Classes>();
	}

	/**
	 * Permet de recuperer la liste des classes du professeur
	 * @return La liste des classes du professeur
	 */
	public ArrayList<Classes> getClasses() {
		return this.classes;
	}

	/**
	 * Fonction permettant d'ajouter une classe a la liste des classes du professeur
	 * si la classe n'est pas deja dans la liste, ajout fonctionne et retourne TRUE
	 * Sinon pas d'ajout de classe et retourne FALSE
	 * @param e La classe a ajouter
	 * @return true si la classe a ete ajouter
	 */
	public boolean addClasses(Classes e) {
		return this.classes.add(e);
	}

	/**
	 * Fonction permettant de savoir si la liste de classe est vide
	 * @return true si la liste est vide
	 */
	public boolean isEmpty() {
		return this.classes.isEmpty();
	}

	/**
	 * Fonction permettant de retirer une classe de la liste
	 * @param e La classe a retirer
	 * @return true si la classe est retiree
	 */
	public boolean removeClasses(Classes e) {
		return this.classes.remove(e);
	}

	

	
	
}
