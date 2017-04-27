package edu.ihm.fiche_exercice_eleve;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import edu.ihm.liste_eleve_prof.TableListeEleve;
import edu.ihm.liste_exercice_eleve.PanelListeExerciceEleve;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Tentative;

/**
 * Panel permettant de visualiser les tentatives effectuer sur un exercice
 * Va utiliser un objet de type ExerciceRealise
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelTentative extends JPanel{

	public PanelTentative(ExerciceRealise exerciceR) {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		int compteur = 1;
		String liste = "<html><ul>";
		for (Tentative tenta : exerciceR.getListeTentatives()) {
			liste += "<li>Tentative"+compteur+"</li>";
			compteur++;
		}
		liste += "</ul></html>";
		this.add(new JLabel(liste));
	}
}
