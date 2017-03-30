package com.sdz.Modele;

/**
 * Représente une Evaluation saisis par un professeur
 * @author Erwan Mazureau
 * @version 30/03/2017
 */
public class Evaluation {
	
	private String note;
	private String commentaire;
	
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
