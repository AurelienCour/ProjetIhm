package edu.ihm.noyau_fonctionnel;

import java.util.ArrayList;

/**
 * Represente une tentative effectuée par un eleve pour resoudre un exercice
 * @author AurelienCourtillat
 * @version 30/03/2017
 */
public class Tentative {
	
	private ArrayList<Action> listeAction; // La liste des actions de la tentative

	/**
	 * Le constructeur de la classe tentative
	 */
	public Tentative() 
	{
		listeAction = new ArrayList<Action>(); 
	}
	
	/**
	 * Permet de recuperer la liste d'action
	 * @return La liste des actions
	 */
	public ArrayList<Action> getListeAction() 
	{
		return this.listeAction;
	}

	/**
	 * Permet de rajouter une action à la liste des actions
	 * si cette derniesre n'existe pas dans la liste
	 * @param act L'action à ajouter
	 * @return true si l'action a ete ajouter, false sinon
	 */
	public boolean addAction(Action act)
	{
		if(this.listeAction.contains(act))
			return false;
		else
			return this.listeAction.add(act);
	}

	/**
	 * Permet de savoir si la liste d'action est vide ou pas
	 * @return true si la liste est vide
	 */
	public boolean isEmpty()
	{
		return this.listeAction.isEmpty();
	}

	/**
	 * Permet de supprimer une action de la liste
	 * @param act	L'action a supprimer de la liste
	 * @return true si l'action a ete supprimer
	 */
	public boolean removeAction(Action act) 
	{
		if (!this.isEmpty() && this.listeAction.contains(act))
			return this.listeAction.remove(act);
		else
			return false;
	}

	/**
	 * Fonction permettant de visualiser toutes les actions d'une tentatives
	 * 
	 */
	public void visualiserTentative()
	{
		
	}

}
