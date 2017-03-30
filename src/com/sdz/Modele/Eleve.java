package com.sdz.Modele;

import java.net.URL;
import java.util.ArrayList;

/**
 * Classe héritant d’Utilisateur. Cette classe permet de représenter un élève
 * @author Groupe8
 * @version 30/03/2017
 */
public class Eleve extends Utilisateur{
	
	private ArrayList<ExerciceRealise> exerciceRealise; //Liste des exercices réalisés par un élève. 
	private Classes classe; // La classe de l’élève
	private URL photo; // Photo de l’élève. 
	
	
	private Eleve(int id, String mdp, String nom, String prenom, Classes classe, URL photo){ //Constructor de la classe Eleve
		
	}
	
	public void addExerciceRealise(Exercice ex){ // Cette méthode permet d’ajouter un exercice réalisé dans la liste des exercices réalisés.
	
	}
	
	public void getPhoto(){// Permet de retourner la photo de l’élève. Affichage ou URL ?
		
	}
	
	
	public void setPhoto(URL photo){// Permet de modifier la photo de l’élève.
		
	}
	public Classes getClasse(){
		return null;// Permet de récupérer la classe de l’élève.
		
	}


}
