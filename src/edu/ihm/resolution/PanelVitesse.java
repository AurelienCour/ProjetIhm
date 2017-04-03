package edu.ihm.resolution;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel permettant le gestion de la vitesse pour une tortue rapide
 * Va modifier un objet de type TortueRapide a l'aide du ControlerTortueG
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelVitesse extends JPanel{

	public PanelVitesse(){
		this.setLayout(new BorderLayout());
		
		this.add(new JLabel("1"), BorderLayout.CENTER);
		
		JPanel panelReglageVitesse = new JPanel();
		panelReglageVitesse.setLayout(new GridLayout(1,2));
		panelReglageVitesse.add(new JButton("-"));
		panelReglageVitesse.add(new JButton("+"));
		
		this.add(panelReglageVitesse,BorderLayout.SOUTH);
	}
	
	
}