package edu.ihm.resolution;


import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.ihm.noyau_fonctionnel.Exercice;

/**
 * Panel comportant le modèle de l'exercice afin de permettre sa visualisation
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelModele extends JPanel{

	public PanelModele(Exercice exercice) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel("Modèle à réaliser"));
		this.add(new JLabel(new ImageIcon(new ImageIcon(exercice.getModele()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))));
	}

}
