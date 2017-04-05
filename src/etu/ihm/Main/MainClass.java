package etu.ihm.Main;

import java.util.Map;
import java.util.Map.Entry;

import edu.ihm.acceuil.AcceuilProf;
import edu.ihm.noyau_fonctionnel.Professeur;

public class MainClass {

	public static void main (String[] args){
		Database db = new Database();
		//db.peuplement();
		db.chargementDonnees();
		Map<String,Object> professeurs = db.getProfesseur();
		Map<String,Object> eleves = db.getEleves();
		int i = 0;
		for(Entry<String, Object> entry2 : professeurs.entrySet()) {
			Professeur test = (Professeur) entry2.getValue();
			AcceuilProf a = new AcceuilProf(test);
		}
	}
}
