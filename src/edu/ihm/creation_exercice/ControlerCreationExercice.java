package edu.ihm.creation_exercice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;

import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.Professeur;
import edu.ihm.noyau_fonctionnel.Utilisateur;

public class ControlerCreationExercice implements ActionListener {
	
	private PanelCreationExercice pane;
	private Professeur prof;
	private Exercice exo;
	
	public ControlerCreationExercice(PanelCreationExercice pane, Utilisateur prof) {
		this.pane = pane;
		this.prof = (Professeur) prof;
	}
	
	public ControlerCreationExercice(PanelCreationExercice panelCreationExercice, Utilisateur user, Exercice exo) {
		this.pane = panelCreationExercice;
		this.prof = (Professeur) prof;
		this.exo = exo;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(exo == null){
			Exercice exercice = new Exercice(pane.getFieldNom().getText(), pane.getCheckBoxSelected().getText(), pane.getFieldModele().getText());
			for (Classes cla : prof.getClasses()) {
				cla.addExercice(exercice);
			}
			pane.afterCreate(exercice);
		}
		else{
			exo.setNomEx(pane.getFieldNom().getText());
			exo.setTypeEx(pane.getCheckBoxSelected().getText());
			exo.setNomImage(pane.getFieldModele().getText());
			pane.afterCreate(exo);
		}
	}

}
