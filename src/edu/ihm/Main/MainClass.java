package edu.ihm.Main;

import java.util.Map;
import java.util.Map.Entry;

import edu.ihm.acceuil.AcceuilEleve;
import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.login.LoginDialog;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Professeur;

public class MainClass {

	public static void main (String[] args){
		Database db = new Database();
		//db.peuplement();
		db.chargementDonnees();
		new LoginDialog(db);
	}
}
