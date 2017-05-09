package edu.ihm.fiche_exercice_eleve;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import edu.ihm.fiche_exercice_prof.ControlerFicheExerciceProf;
import edu.ihm.liste_eleve_prof.TableListeEleve;
import edu.ihm.liste_exercice_eleve.PanelListeExerciceEleve;
import edu.ihm.noyau_fonctionnel.Classes;
import edu.ihm.noyau_fonctionnel.Eleve;
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
		JPanel debut = new JPanel();
		debut.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel titre = new JLabel("        Liste des tentatives :");
		titre.setFont(new Font("Arial", Font.PLAIN, 20));
		debut.add(titre);
		this.add(debut);
		
		int compteur = 1;
		for (Tentative tenta : exerciceR.getListeTentatives()) {
			JPanel info = new JPanel();
			info.setLayout(new FlowLayout(FlowLayout.LEFT,30,30));
			JLabel name = new JLabel("                - Tentative"+compteur);
			name.setFont(new Font("Arial", Font.PLAIN, 15));
			info.add(name);
			JButton voir = new JButton("Voir");
			voir.addActionListener(new ControlerPanelFicheExerciceEleve(exerciceR, tenta));
			info.add(voir);
			this.add(info);
			compteur++;
		}
	}
}
