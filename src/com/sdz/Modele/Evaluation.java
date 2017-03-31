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
	 * @param note	La note mise a l'exercice
	 * @param commentaire	Le commentaire de l'exercice
	 */
	public Evaluation(String note, String commentaire){
		
	}
	
	public String getNote(){
		return(note);
	}
	
	public void setNote(String note){
		this.note = note;
	}
	
	public String getCommentaire(){
		return(commentaire);
	}
	
	public void setCommentaire(String commentaire){
		this.commentaire = commentaire;
	}
	
}
