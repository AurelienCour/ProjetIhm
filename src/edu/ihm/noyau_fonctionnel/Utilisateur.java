package edu.ihm.noyau_fonctionnel;

/**
 * La classe utilisateur représente les personnes pouvant se connecter à l’application
 * @author AurelienCourtillat
 * @version 30/03/2017
 */
/**
 * @author Aurelien
 *
 */
public abstract class Utilisateur {
	
	private String identifiant; // L'identifiant de connexion
	private String motDePasse;	// Le mot de passe de connexion
	private String nom;			// Le nom de l'utilisateur
	private String prenom;		// Le prenom de l'utilisateur
	private static int nombreUtilisateur = 0;
	
	/**
	 * Constructeur de la classe utilisateur
	 * Si l'identifiant est vide le remplace par "utilisateur" suivi du numero d'utilisateur
	 * Si le mot de passe est vide le remplace par defaut par "***"
	 * Si le nom est vide remplace le nom par defaut a "nom"
	 * Si le prenom est vide remplace le prenom a "prenom"
	 * @param identifiant	L'identifiant de l'utilisateur
	 * @param motDePasse	Le mot de passe de l'utilisateur
	 * @param nom			Le nom de l'utilisateur
	 * @param prenom		Le prenom de l'utilisateur
	 */
	public Utilisateur (String identifiant, String motDePasse, String nom, String prenom){
		nombreUtilisateur += 1;
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
