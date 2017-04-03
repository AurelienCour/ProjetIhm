package edu.ihm.noyau_fonctionnel;

/**
 * Action effectuée par l’élève pour réaliser l’exercice
 * composée d’une tortue logo et de l’action effectuée sous forme textuelle
 * @author Erwan Mazureau
 * @version 03/04/2017
 */
public class Action {
	
	private TortueG tortue; //tortue logo affichée à l'écran 
	private String action; //dernière action effectuée par la tortue sous forme textuelle 
	
	/**
	 * Constructeur de la classe Action,
	 * prend en paramètres un attribut de type TortueG,
	 * si null alors on initialise avec une tortueG,
	 * et un attribut de type String,
	 * si null alors on initialise avec la valeur "avancer"
	 * @param tortue : la tortue sur laquelle va être effectué l'action
	 * @param action : l'action qui a été effectuée
	 */
	public Action(TortueG tortue, String action){

	}
	
	/**
	 * Accesseur de l'attribut tortue
	 * @return renvoie l'attribut tortue
	 */
	public TortueG getTortue(){
		return tortue;
	}
	
	/**
	 * Accesseur de l'attribut action
	 * @return renvoie l'attribut action
	 */
	public String getAction(){
		return action;
	}
	
	
}
