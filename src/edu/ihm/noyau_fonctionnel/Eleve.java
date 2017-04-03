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
	 * Si l'identifiant est vide le remplace par "utilisateur" suivi du numero d'utilisateur
	 * Si le mot de passe est vide le remplace par defaut par "***"
	 * Si le nom est vide remplace le nom par defaut a "nom"
	 * Si le prenom est vide remplace le prenom a "prenom"
	 * Si le classe est vide, laisse "null"
	 * Si photo est vide, photo par défault
	 * @param identifiant L'identifiant de l'eleve, string
	 * @param motDePasse  Le mot de passe de l'élève
	 * @param nom		  Le nom de l'élève
	 * @param prenom	  Le prenom de l'élève
	 * @param classe	  La classe de l'élève
	 * @param string		  La photo de l'élève
	 */
	public Eleve(String identifiant, String motDePasse, String nom, String prenom,
			Classes classe, String photo) {
		super(identifiant, motDePasse, nom, prenom);
		this.classe = classe;
		this.photo = Eleve.class.getResource(photo);
	}

	
	/**
	 * Cette méthode permet d’ajouter un exercice réalisé dans la liste des exercices réalisés.
	 * Méthode callable uniquement si il y a au moins un exercice et un enfant dans dans le systeme.
	 * @param ex exercice réalisé par l'élève
	 */
		
	public void addExerciceRealise(ExerciceRealise ex){ 
		this.exerciceRealise.add(ex);		
	}
	
	
	/**
	 * Permet de retourner la photo de l’élève. Affichage ou URL ?
	 */
	public URL getPhoto(){
		return this.photo;
	}
	
	/**
	 * Permet de modifier la photo de l’élève.
	 * Callable uniquement si au moins un enfant dans le systeme.
	 * @param photo URL de la photo de l'élève
	 */
	public void setPhoto(URL photo){
		this.photo = photo;
	}
	
	/**
	 * Permet de récupérer la classe de l’élève.
	 * @return TODO a voir ce qu'on return
	 */
	public Classes getClasse(){
		return this.classe;
	}
	
	public void setClasse(Classes c){
		classe = c;
	}

}
