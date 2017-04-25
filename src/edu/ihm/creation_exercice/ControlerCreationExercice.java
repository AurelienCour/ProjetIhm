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
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ArrayList<JCheckBox> test = new ArrayList<JCheckBox>();
		test = pane.getCheckBox();
		
		for (JCheckBox jCheckBox : test) {
			if(jCheckBox.isSelected()){
				exo = new Exercice(pane.getFieldNom().getText(), jCheckBox.getText(), pane.getFieldModele().getText());
				for (Classes cla : prof.getClasses()) {
					cla.addExercice(exo);
				}
				pane.afterCreate(exo);
				break;
			}
		}
	}

}
