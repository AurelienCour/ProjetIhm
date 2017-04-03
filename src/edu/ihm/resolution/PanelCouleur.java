package edu.ihm.resolution;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel permettant de choisir la couleur de la tortue couleur
 * utiliser lors de la résolution d'exercice
 * Va modifier la tourtueG va utiliser la classe ControlerTortueG
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelCouleur extends JPanel{

	public PanelCouleur(){
		this.setLayout(new GridLayout(3,3));
		this.add(new JButton("N"));
		this.add(new JButton("B"));
		this.add(new JButton("R"));
		this.add(new JButton("V"));
		this.add(new JButton("V"));
		this.add(new JButton("BF"));
	}
}
