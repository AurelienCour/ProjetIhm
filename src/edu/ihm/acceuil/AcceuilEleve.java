package edu.ihm.acceuil;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import edu.ihm.Main.Database;
import edu.ihm.fiche_exercice_eleve.PanelFicheExerciceEleve;
import edu.ihm.liste_exercice_eleve.PanelListeExerciceEleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.Utilisateur;

/**
 * Classe héritant d'Acceuil, représente l'acceuil d'un élève
 * @author Aurelien
 *
 */
public class AcceuilEleve extends Acceuil{

	private JPanel panelInfo; // Le panel d'information qui change suivant la navigation
	
	/**
	 * Le constructeur de notre class
	 * @param user L'utilisateur connecté
	 * @param db La base de données de l'application
	 */
	public AcceuilEleve(Utilisateur user, Database db) {
		super(user, db);
		panelInfo = new JPanel();
		panelInfo.setLayout(new BorderLayout());
		goListeExercice();
		this.add(panelInfo,BorderLayout.CENTER);
	}
	
	/**
	 * Permet de modifier le panelInfo pour afficher la liste des exercices
	 */
	public void goListeExercice(){
		panelInfo.removeAll();
		panelInfo.add(new PanelListeExerciceEleve(this));
		panelInfo.revalidate();
	}
	
	/**
	 * Permet de modifier le panelInfo pour afficher la fiche d'un exercice
	 * @param exercice L'exercice que l'on souhaite affiché
	 */
	public void goFicheExercice(Exercice exercice){
		panelInfo.removeAll();
		panelInfo.add(new PanelFicheExerciceEleve(exercice, this.getUser(), this));
		panelInfo.revalidate();
	}
}
