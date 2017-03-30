package com.sdz.Modele;

/**
 * Action effectuée par l’élève pour réaliser l’exercice
 * composée d’une tortue logo et de l’action effectuée sous forme textuelle
 * @author Erwan Mazureau
 * @version 30/03/2017
 */
public class Action {
	
	private TortueG tortue;
	private String action;
	
	public Action(TortueG to, String ac){
		setTortue(to);
		setAction(ac);
	}
	
	public TortueG getTortue(){
		return tortue;
	}
	
	public void setTortue(TortueG t){
		this.tortue = t;
	}
	
	public String getAction(){
		return action;
	}
	
	public void setAction(String s){
		this.action = s;
	}
	
}
