package com.sdz.Modele;

/**
 * Représente une Evaluation saisis par un professeur
 * @author Erwan Mazureau
 * @version 30/03/2017
 */
public class Evaluation {
	
	private String note; //note textuelle attribuée par le professeur
	private String commentaire; //commentaire textuel du professeur sur le travail de l'élève
	
	/**
	 * Constructeur de la classe Evaluation
	 * prend en paramètres deux attributs de type String
	 */
	public Evaluation(String no, String co){
		setNote(no);
		setCommentaire(co);
	}
	
	public String getNote(){
		return(n);
	}
	
	public void setNote(String n){
		this.note = n;
	}
	
	public String getCommentaire(){
		return(c);
	}
	
	public void setCommentaire(String c){
		this.commentaire = c;
	}
	
}
