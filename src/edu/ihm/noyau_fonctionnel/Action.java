package edu.ihm.noyau_fonctionnel;

import edu.ihm.tortue.TortueG;

/**
 * Action effectuée par l’élève pour réaliser l’exercice
 * @author Aurelien
 *
 */
public class Action {
	
	private String action; //dernière action effectuée par la tortue sous forme textuelle 
	
	/**
	 * Constructeur de la classe Action,
	 * @param action : l'action qui a été effectuée
	 */
	public Action(String action){
		this.action = action;
	}
	
	/**
	 * Accesseur de l'attribut action
	 * @return renvoie l'attribut action
	 */
	public String getAction(){
		return this.action;
	}
	
	/**
	 * Modifieur de l'attribut action
	 * @param action La nouvelle action
	 */
	public void setAction(String action){
		this.action = action;
	}	
	
}
