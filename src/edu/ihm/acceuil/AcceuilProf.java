package edu.ihm.acceuil;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Map;

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
 * La Jframe principal de l'application
 * Permet la visualisation du menu et de la fenetre principal changeant en fonction du type d'utilisateur
 * @author Groupe8
 * @version 30/03/2017
 */
public class AcceuilProf extends Acceuil{
	
	private JPanel panelInfo;
	
	public AcceuilProf (Professeur user, Database db){
		super(user,db);
		panelInfo = new JPanel();
		panelInfo.setLayout(new BorderLayout());
		goListeEleve();
		this.add(panelInfo,BorderLayout.CENTER);
	}

	public void goListeEleve(){
		panelInfo.removeAll();
		panelInfo.add(new PanelListeEleveProf(this));
		panelInfo.revalidate();
	}
	
	public void goListeExercice(Classes cl){
		panelInfo.removeAll();
		panelInfo.add(new PanelListeExerciceProf(cl, this));
		panelInfo.revalidate();
	}

	public void goFicheEleve(Eleve eleve){
		panelInfo.removeAll();
		panelInfo.add(new PanelFicheEnfantProf(eleve,this));
		panelInfo.revalidate();
	}
	
	public void goFicheExercice(Exercice exercice){
		panelInfo.removeAll();
		panelInfo.add(new PanelFicheExerciceProf(exercice,(Professeur) this.getUser(),this));
		panelInfo.revalidate();
	}

	public void goListeEleve(Classes nodeInfo) {
		panelInfo.removeAll();
		panelInfo.add(new PanelListeEleveProf(this, nodeInfo));
		panelInfo.revalidate();
	}

	public void goCreationExercice(Classes cl) {
		panelInfo.removeAll();
		panelInfo.add(new PanelCreationExercice(this, cl));
		panelInfo.revalidate();
	}
	
	public void goModificationExercice (Exercice exo) {
		panelInfo.removeAll();
		panelInfo.add(new PanelCreationExercice(this, exo));
		panelInfo.revalidate();
	}

}
