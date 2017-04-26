package edu.ihm.fiche_exercice_prof;

import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Professeur;

/**
 * Panel permettant de visualiser la fiche d'un exercice pour un professeur
 * Va utiliser un objet de type Exercice
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelFicheExerciceProf extends JPanel{
	
	private Exercice exercice;
	
	public PanelFicheExerciceProf(Exercice exercice, Professeur user){
		this.exercice = exercice;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(new JLabel(new ImageIcon(new ImageIcon(exercice.getModele()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))));
		this.add(new JLabel(exercice.getNomEx()));
		this.add(new JLabel(exercice.getTypeEx()));
		this.add(new JLabel("Liste des enfants ayant réalisé l'exercice :"));
		for (Classes classes : user.getClasses()) {
			for (Eleve eleve : classes.getEleves()) {
				for (ExerciceRealise exoR : eleve.getExerciceRealise()) {
					if(exoR.getExerciceFait().equals(exercice)){
						this.add(new JLabel(eleve.getNom()));
					}
				}
			}
		}
	}

}
