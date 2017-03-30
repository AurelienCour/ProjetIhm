package com.sdz.Modele;

/**
 * La classe utilisateur représente les personnes pouvant se connecter à l’application
 * @author Groupe8
 * @version 30/03/2017
 */
/**
 * @author Aurelien
 *
 */
public abstract class Utilisateur {
	
	private String identifiant;
	private String motDePasse;
	private String nom;
	private String prenom;
	
	/**
	 * Constructeur de la classe utilisateur
	 * @param identifiant	L'identifiant de l'utilisateur
	 * @param motDePasse	Le mot de passe de l'utilisateur
	 * @param nom			Le nom de l'utilisateur
	 * @param prenom		Le prenom de l'utilisateur
	 */
	public Utilisateur (String identifiant, String motDePasse, String nom, String prenom){
		
	}
	
	/**
	 * permet de récupérer l'identifiant de l'utilisateur
	 * @return L'identifiant de l'utilisateur
	 */
	public String getIdentifiant(){
		return identifiant;
	}
	
	/**
	 * permet de récupérer le mot de passe de l'utilisateur
	 * @return	Le mot de passe de l'utilisateur
	 */
	public String getMotDePasse(){
		return motDePasse;
	}
	
	/**
	 * permet de récupérer le nom de l'utilisateur
	 * @return Le nom de l'utilisateur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * permet de récupérer le prenom de l'utilisateur
	 * @return Le prenom de l'utilisateur
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Permet a l'utilisateur de modifier son mot de passe
	 * @param motDePasse	Le nouveau mot de passe
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	

}
