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
		JLabel titre = new JLabel("<html><h1>Liste des tentatives :</h1></html>");
		this.add(titre);
		int compteur = 1;
		for (Tentative tenta : exerciceR.getListeTentatives()) {
			JPanel panelTentative = new JPanel();
			panelTentative.add(new JLabel("Tentative"+compteur));
			JButton visualiser = new JButton("Voir");
			visualiser.addActionListener(new ControlerPanelFicheExerciceEleve(exerciceR, tenta));
			panelTentative.add(visualiser);
			this.add(panelTentative);
			compteur++;
		}
		
	}
}
