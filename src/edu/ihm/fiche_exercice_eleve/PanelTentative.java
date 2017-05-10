package edu.ihm.fiche_exercice_eleve;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Tentative;

/**
 * Panel comportant les informations a propos des différentes tentatives
 * @author Aurelien
 *
 */
public class PanelTentative extends JPanel{

	/**
	 * Le constructeur de la classe permettant de récupérer les tentatives d'un exercice
	 * @param exerciceR L'exercice dont ou souhaite les différentes tentatives
	 */
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
