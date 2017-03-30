package com.sdz.Modele;

/**
 * Action effectuée par l’élève pour réaliser l’exercice
 * composée d’une tortue logo et de l’action effectuée sous forme textuelle
 * @author Erwan Mazureau
 * @version 30/03/2017
 */
public class Action {
	
	private TortueG tortue; //tortue logo affichée à l'écran 
	private String action; //dernière action effectuée par la tortue sous forme textuelle 
	
	/**
	 * Constructeur de la classe Action
	 * prend en paramètres un attribut de type TortueG 
	 * et un attribut de type String
	 */
	public Action(TortueG to, String ac){
		setTortue(to);
		setAction(ac);
	}
	
	/**
	 * Accesseur de l'attribut tortue
	 * @return renvoie l'attribut tortue
	 */
	public TortueG getTortue(){
		return tortue;
	}
	
	/**
	 * Modifieur de l'attribut tortue
	 * prend en paramètre un attribut de type TortueG
	 * modifie la valeur de l'attribut tortue par l'attribut entré
	 */	
	public void setTortue(TortueG t){
		this.tortue = t;
	}
	
	/**
	 * Accesseur de l'attribut action
	 * @return renvoie l'attribut action
	 */
	public String getAction(){
		return action;
	}
	
	/**
	 * Modifieur de l'attribut action
	 * prend en paramètre un attribut de type String
	 * modifie la valeur de l'attribut action par l'attribut entré
	 */	
	public void setAction(String s){
		this.action = s;
	}
	
}
