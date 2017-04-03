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
	 * @param identifiant L'identifiant de l'eleve, string
	 * identifiant ne peut etre null, erreur si non rentré
	 * @param motDePasse  Le mot de passe de l'élève
	 * mot de passe ne peut etre null, erreur si non rentré
	 * @param nom		  Le nom de l'élève
	 * Si nom de de l'élève null, erreur si non rentré
	 * @param prenom	  Le prenom de l'élève
	 * si prénom de l'élève null, erreur si non rentré
	 * @param classe	  La classe de l'élève
	 * classe not null, erreur si non rentré
	 * @param photo		  La photo de l'élève
	 * photo n'est pas obligatoire, donc peut etre null
	 */
	public Eleve(String identifiant, String motDePasse, String nom, String prenom,
			Classes classe, URL photo) {
		super(identifiant, motDePasse, nom, prenom);
		this.classe = classe;
		this.photo = photo;
	}

	
	/**
	 * Cette méthode permet d’ajouter un exercice réalisé dans la liste des exercices réalisés.
	 * Méthode callable uniquement si il y a au moins un exercice et un enfant dans dans le systeme.
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
	 * Callable uniquement si au moins un enfant dans le systeme.
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
