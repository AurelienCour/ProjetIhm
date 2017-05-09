package edu.ihm.construction_exercice;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import edu.ihm.noyau_fonctionnel.Exercice;

/**
 * Panel comportant le modèle de l'exercice afin de permettre sa visualisation
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelModele extends JPanel{

	public PanelModele(Exercice exercice) {
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel titre = new JLabel("Modèle à réaliser");
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setFont(new Font("Arial", Font.ITALIC, 15));
		JLabel image = new JLabel(new ImageIcon(new ImageIcon(exercice.getModele()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		image.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(titre,BorderLayout.NORTH);
		this.add(image,BorderLayout.CENTER);
	}

}
