package edu.ihm.Main;

import edu.ihm.login.LoginDialog;

public class MainClass {

	public static void main (String[] args){
		Database db = new Database();
		//db.peuplement();
		db.chargementDonnees();
		new LoginDialog(db);
	}
}
