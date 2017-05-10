package edu.ihm.noyau_fonctionnel;

/**
 * Représente l'évaluation saisie par un professeur sur la tentative d'un élève.
 * @author Aurelien
 *
 */
public class Evaluation {
	
	private String note; //note textuelle attribuée par le professeur
	private String commentaire; //commentaire textuel du professeur sur le travail de l'élève
	
	/**
	 * Constructeur de la classe Evaluation
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
	 * Permet de modifier la note
	 * @param note La nouvelle note
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
	 * Permet de modifier la valeur du commentaire
	 * @param commentaire La nouvelle valeur
	 */
	public void setCommentaire(String commentaire){
		this.commentaire = commentaire;
	}
	
}
