package edu.ihm.noyau_fonctionnel;

import java.net.URL;
import java.util.ArrayList;

/**
 * Classe héritant d’Utilisateur. Cette classe permet de représenter un élève
 * @author MathiasAntunes
 * @version 30/03/2017
 */
public class Eleve extends Utilisateur{
	
	/**
	 * Liste des exercices réalisés par un élève.
	 */
	private ArrayList<ExerciceRealise> exerciceRealise;
	
	/**
	 * La classe de l’élève
	 */
	private Classes classe;
	
	/**
	 * Photo de l’élève. 
	 */
	private URL photo;
	
	/**
	 * Constructeur de la classe Eleve
	 * @param identifiant L'identifiant de l'eleve
	 * @param motDePasse  Le mot de passe de l'élève
	 * @param nom		  Le nom de l'élève
	 * @param prenom	  Le prenom de l'élève
	 * @param classe	  La classe de l'élève
	 * @param photo		  La photo de l'élève
	 */
	public Eleve(String identifiant, String motDePasse, String nom, String prenom,
			Classes classe, URL photo) {
		super(identifiant, motDePasse, nom, prenom);
		this.classe = classe;
		this.photo = photo;
	}

	
	/**
	 * Cette méthode permet d’ajouter un exercice réalisé dans la liste des exercices réalisés.
	 * @param ex exercice réalisé par l'élève
	 */
	public void addExerciceRealise(Exercice ex){ 
	
	}
	
	
	/**
	 * Permet de retourner la photo de l’élève. Affichage ou URL ?
	 */
	public void getPhoto(){
		
	}
	
	/**
	 * Permet de modifier la photo de l’élève.
	 * @param photo URL de la photo de l'élève
	 */
	public void setPhoto(URL photo){
		
	}
	
	/**
	 * Permet de récupérer la classe de l’élève.
	 * @return TODO a voir ce qu'on return
	 */
	public Classes getClasse(){
		return null;
		
	}


}
