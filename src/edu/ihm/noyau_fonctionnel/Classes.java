package edu.ihm.noyau_fonctionnel;

import java.util.ArrayList;

/**
 * Class permettant de représenté une classe composé d'élèves et d'exercices
 * @author Aurelien
 *
 */
public class Classes {

	private ArrayList<Exercice> exercices; //Liste d exercices à faire pour les eleves de cette classe.
	private ArrayList<Eleve> eleves; //Liste des eleves qui font partie de la classe. 
	private String nomClasse; // Le nom de la classe
	
	/**
	 * Constructeur de la classe Classe.
	 * @param nomClasse Le nom de la classe
	 */
	public Classes(String nomClasse)
	{
		this.exercices = new ArrayList<Exercice>();
		this.eleves = new ArrayList<Eleve>();
		this.nomClasse = nomClasse;
	}
	
	/**
	 * Fonction permettant d'ajouter un exercice si ce dernier n'existe pas déja
	 * @param ex L'exercice a ajouter
	 */
	public void addExercice(Exercice ex)
	{ 
		if(!this.exercices.contains(ex))
			this.exercices.add(ex);
	}
	
	/**
	 * Permet de récupérer le nom de la classe
	 * @return Le nom de la classe
	 */
	public String getNomClasse(){
		return nomClasse;
	}
	
	/**
	 * Fonction permettant de supprimer un exercie si ce dernier est présent dans la liste
	 * @param ex L'exercice à supprimer
	 */
	public void suppExercice(Exercice ex)
	{
		if(this.exercices.contains(ex))
			this.exercices.remove(ex);
	}
	
	/**
	 * Renvoie l'exercice � l'emplacement sp�cifi� de la liste d'exercices
	 * @param num numero de l'exercice dans la liste
	 * @return L'exercice correspondant
	 */
	public Exercice getExercice(int num)
	{
		return this.exercices.get(num);
	}
	
	/**
	 * Permet de récupérer la liste des exercices de la classe
	 * @return La liste des exercices
	 */
	public ArrayList<Exercice> getExercices(){
		return this.exercices;
	}
	
	/**
	 * Fonction permettant d'ajouter un élève a la classe si elle ne le contient pas déja
	 * @param el l'élève à ajouter
	 */
	public void addEleve(Eleve el)
	{
		if(!this.eleves.contains(el))
			this.eleves.add(el);
	}
	
	/**
	 * Fonction permettant de supprimé un élève de la classe si celui-ci est bien présent
	 * @param el L'élève à supprimer
	 */
	public void suppEleve(Eleve el)
	{
		if(this.eleves.contains(el))
			this.eleves.remove(el);
	}
	
	/**
	 * Permet de récupérer la liste des élèves de la classe
	 * @return La liste des élèves
	 */
	public ArrayList<Eleve> getEleves(){
		return this.eleves;
	}
	
	/**
	 * Fonction permettant de connaitre le nombre d'élèves présent dans la classe
	 * @return Le nombre d'élève présent dans la classe
	 */
	public int getNombreEleve(){
		return this.eleves.size();
	}

	public boolean containExercice(Exercice exercice) {
		return this.exercices.contains(exercice);
	}
}
