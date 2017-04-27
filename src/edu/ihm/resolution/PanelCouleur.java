package edu.ihm.resolution;

import java.awt.Color;
import java.awt.GridLayout;
import java.lang.reflect.Field;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import edu.ihm.tortue.TortueCouleur;

/**
 * Panel permettant de choisir la couleur de la tortue couleur
 * utiliser lors de la résolution d'exercice
 * Va modifier la tourtueG va utiliser la classe ControlerTortueG
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelCouleur extends JPanel{

	public PanelCouleur(TortueCouleur myTurtle, PanelResolution panelResolution){
		this.setLayout(new GridLayout(3,2));
		TitledBorder  title = BorderFactory.createTitledBorder(
				BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black), "Couleur");
		title.setTitleJustification(TitledBorder.CENTER);
		this.setBorder(title);
		JButton black = new JButton();
		black.setBackground(Color.BLACK);
		black.addActionListener(new ControlerResolution(this, "black", myTurtle, panelResolution));
		JButton red = new JButton();
		red.setBackground(Color.RED);
		red.addActionListener(new ControlerResolution(this, "red", myTurtle, panelResolution));
		JButton blue = new JButton();
		blue.setBackground(Color.BLUE);
		blue.addActionListener(new ControlerResolution(this, "blue", myTurtle, panelResolution));
		JButton green = new JButton();
		green.setBackground(Color.GREEN);
		green.addActionListener(new ControlerResolution(this, "green", myTurtle, panelResolution));
		JButton yellow = new JButton();
		yellow.setBackground(Color.YELLOW);
		yellow.addActionListener(new ControlerResolution(this, "yellow", myTurtle, panelResolution));
		JButton magenta = new JButton();
		magenta.setBackground(Color.MAGENTA);
		magenta.addActionListener(new ControlerResolution(this, "magenta", myTurtle, panelResolution));
		this.add(black);
		this.add(red);
		this.add(blue);
		this.add(green);
		this.add(yellow);
		this.add(magenta);
	}

	public void changeCouleur(String idAction) {
		TitledBorder  title;
		switch (idAction) {
		case "black":
			title = BorderFactory.createTitledBorder(
					BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black), "Couleur");
			title.setTitleJustification(TitledBorder.CENTER);
			break;
		case "red":
			title = BorderFactory.createTitledBorder(
					BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red), "Couleur");
			title.setTitleJustification(TitledBorder.CENTER);
			break;
		case "blue":
			title = BorderFactory.createTitledBorder(
					BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue), "Couleur");
			title.setTitleJustification(TitledBorder.CENTER);
			break;
		case "green":
			title = BorderFactory.createTitledBorder(
					BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green), "Couleur");
			title.setTitleJustification(TitledBorder.CENTER);
			break;
		case "yellow":
			title = BorderFactory.createTitledBorder(
					BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow), "Couleur");
			title.setTitleJustification(TitledBorder.CENTER);
			break;
		case "magenta":
			title = BorderFactory.createTitledBorder(
					BorderFactory.createMatteBorder(2, 2, 2, 2, Color.magenta), "Couleur");
			title.setTitleJustification(TitledBorder.CENTER);
			break;
		default:
			title = BorderFactory.createTitledBorder(
					BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black), "Couleur");
			title.setTitleJustification(TitledBorder.CENTER);
			break;
		}
		this.setBorder(title);
	}
}
