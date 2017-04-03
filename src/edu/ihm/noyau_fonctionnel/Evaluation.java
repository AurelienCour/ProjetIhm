package edu.ihm.noyau_fonctionnel;

/**
 * Représente l'évaluation saisie par un professeur sur la tentative d'un élève.
 * @author Erwan Mazureau
 * @version 03/04/2017
 */
public class Evaluation {
	
	private String note; //note textuelle attribuée par le professeur
	private String commentaire; //commentaire textuel du professeur sur le travail de l'élève
	
	/**
	 * Constructeur de la classe Evaluation
	 * prend en paramètres deux attributs de type String,
	 * si null, on initialise avec les valeurs "En cours d'acquisition." pour la note
	 * et "Vu." pour le commentaire.
	 * @param note : la note mise a l'exercice
	 * @param commentaire : le commentaire de l'exercice
	 */
	public Evaluation(String note, String commentaire){
		setNote(note);
		setCommentaire(commentaire);
	}
	
	/**
	 * Accesseur de l'attribut note
	 * @return renvoie la valeur de la note
	 */
	public String getNote(){
		return this.note;
	}
	
	/**
	 * Modifieur de l'attribut note
	 * @return remplace la valeur de la note
	 */
	public void setNote(String note){
		this.note = note;
	}
	
	/**
	 * Accesseur de l'attribut commentaire
	 * @return renvoie la valeur du commentaire
	 */
	public String getCommentaire(){
		return this.commentaire;
	}
	
	/**
	 * Modifieur de l'attribut commentaire
	 * @return remplace la valeur du commentaire
	 */
	public void setCommentaire(String commentaire){
		this.commentaire = commentaire;
	}
	
}
