package edu.ihm.fiche_exercice_eleve;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import edu.ihm.liste_eleve_prof.TableListeEleve;
import edu.ihm.liste_exercice_eleve.PanelListeExerciceEleve;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;

/**
 * Panel permettant de visualiser les tentatives effectuer sur un exercice
 * Va utiliser un objet de type ExerciceRealise
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelTentative extends JPanel{

	public PanelTentative(ExerciceRealise exerciceR) {
		this.add(new JLabel("ListeTentativeEleve"));
		this.add(new JButton("Retour"));
	}
}
