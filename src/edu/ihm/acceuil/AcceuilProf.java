package edu.ihm.acceuil;


import java.awt.BorderLayout;
import javax.swing.JPanel;
import edu.ihm.Main.Database;
import edu.ihm.creation_exercice.PanelCreationExercice;
import edu.ihm.fiche_enfant_prof.PanelFicheEnfantProf;
import edu.ihm.fiche_exercice_prof.PanelFicheExerciceProf;
import edu.ihm.liste_eleve_prof.PanelListeEleveProf;
import edu.ihm.liste_exercice_prof.PanelListeExerciceProf;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.Professeur;

/**
 * Classe héritant d'Acceuil, représente l'acceuil d'un professeur
 * @author Aurelien
 *
 */
public class AcceuilProf extends Acceuil{
	
	private JPanel panelInfo; // Le panel d'information qui change suivant la navigation
	
	/**
	 * Le constructeur de notre class
	 * @param user L'utilisateur connecté
	 * @param db La base de données de l'application
	 */
	public AcceuilProf (Professeur user, Database db){
		super(user,db);
		panelInfo = new JPanel();
		panelInfo.setLayout(new BorderLayout());
		goListeEleve();
		this.add(panelInfo,BorderLayout.CENTER);
	}

	/**
	 * Fonction permettant de modifier le panelInfo afin d'afficher la liste des élèves
	 */
	public void goListeEleve(){
		panelInfo.removeAll();
		panelInfo.add(new PanelListeEleveProf(this));
		panelInfo.revalidate();
	}
	
	/**
	 * Fonction permettant de modifier le panelInfo afin d'afficher la liste des exercices d'une classe donnée
	 * @param cl La classe dont on souhaite connaitre les exercices
	 */
	public void goListeExercice(Classes cl){
		panelInfo.removeAll();
		panelInfo.add(new PanelListeExerciceProf(cl, this));
		panelInfo.revalidate();
	}

	/**
	 * Fonction permettant de modifier le panelInfo afin d'afficher la fiche d'un élève
	 * @param eleve L'élève dont on souhaite récupérer les informations
	 */
	public void goFicheEleve(Eleve eleve){
		panelInfo.removeAll();
		panelInfo.add(new PanelFicheEnfantProf(eleve,this));
		panelInfo.revalidate();
	}
	
	/**
	 * Fonction permettant de modifier le panelInfo afin d'afficher la fiche d'un exercice
	 * @param exercice L'exercice dont ou souhaite avoir les informations
	 */
	public void goFicheExercice(Exercice exercice){
		panelInfo.removeAll();
		panelInfo.add(new PanelFicheExerciceProf(exercice,(Professeur) this.getUser(),this));
		panelInfo.revalidate();
	}

	/**
	 * Fonction permettant de modifier le panelInfo afin d'afficher la liste des élèves d'une classe
	 * @param classe La classe dont on souhaite connaitre les élèves
	 */
	public void goListeEleve(Classes classe) {
		panelInfo.removeAll();
		panelInfo.add(new PanelListeEleveProf(this, classe));
		panelInfo.revalidate();
	}

	/**
	 * Fonction permettant de modifier le panelInfo afin d'afficher l'interface de création d'exercice
	 * @param cl La classe pour laquel l'exercice est ajouter
	 */
	public void goCreationExercice(Classes cl) {
		panelInfo.removeAll();
		panelInfo.add(new PanelCreationExercice(this, cl));
		panelInfo.revalidate();
	}
	
	/**
	 * Fonction permettant de  modifier le panelInfo afin d'afficher l'interface de modification d'exercice
	 * @param exo L'exercice que l'on souhaite modifier
	 */
	public void goModificationExercice (Exercice exo) {
		panelInfo.removeAll();
		panelInfo.add(new PanelCreationExercice(this, exo));
		panelInfo.revalidate();
	}

}
