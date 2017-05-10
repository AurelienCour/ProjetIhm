package edu.ihm.Main;

import edu.ihm.login.LoginDialog;

/**
 * Le main de notre application
 * @author Aurelien
 *
 */
public class MainClass {

	/**
	 * Le main
	 * @param args Paramètre d'entré
	 */
	public static void main (String[] args){
		Database db = new Database(); // Création de la base de données
		new LoginDialog(db); // Lancement de l'interface de connexion
	}
}
