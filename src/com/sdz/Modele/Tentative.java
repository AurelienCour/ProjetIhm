package com.sdz.Modele;

import java.util.ArrayList;

/**
 * Represente une tentative effectuée par un élève pour résoudre un exercice
 * @author Groupe8
 * @version 30/03/2017
 */
public class Tentative {
	
	private ArrayList<Action> listeAction;

	/**
	 * Le constructeur de la classe tentative
	 */
	public Tentative() {
		
	}
	
	/**
	 * Permet de récupérer la liste d'action
	 * @return
	 */
	public ArrayList<Action> getListeAction() {
		return listeAction;
	}

	/**
	 * Permet de rajouter une action à la liste des actions
	 * si cette dernière n'existe pas dans la liste
	 * @param arg0 L'action à ajouter, true si l'action à été ajouter, false sinon
	 */
	public boolean addAction(Action arg0) {
		return listeAction.add(arg0);
	}

	/**
	 * Permet de savoir si la liste d'action est vide ou pas
	 * @return true si la liste est vide
	 */
	public boolean isEmpty() {
		return listeAction.isEmpty();
	}

	/**
	 * Permet de supprimer une action de la liste
	 * @param arg0	L'action a supprimer de la liste
	 * @return true si l'action à été supprimer
	 */
	public boolean removeAction(Action arg0) {
		return listeAction.remove(arg0);
	}

	/**
	 * Fonction permettant de visualiser toutes les actions d'une tentatives
	 */
	public void visualiserTentative(){
		
	}

}
