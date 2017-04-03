package edu.ihm.resolution;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel comportant les boutons pour resoudre un exercice
 * Va utiliser les objets ExerciceRealise et TortueG
 * Va utiliser le controler ControlerExercice
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelResolution extends JPanel{
	
	private PanelCouleur panelCouleur;
	private PanelVitesse panelVitesse;

	public PanelResolution(){
		this.panelCouleur = new PanelCouleur();
		this.panelVitesse = new PanelVitesse();
		
		this.setLayout(new BorderLayout());
		
		
		JPanel boutonBase = new JPanel();
		boutonBase.setLayout(new GridLayout(2,2));
		boutonBase.add(new JButton("AVANCER"));
		boutonBase.add(new JButton("TRACER"));
		boutonBase.add(new JButton("TOURNER"));
		boutonBase.add(new JButton("RETOUR"));
		
		JPanel boutonBaseTermine = new JPanel();
		boutonBaseTermine.setLayout(new FlowLayout());
		boutonBaseTermine.add(boutonBase);
		boutonBaseTermine.add(new JButton("TERMINE !"));
		
		this.add(boutonBaseTermine, BorderLayout.CENTER);
	}
	
	public void addPanelCouleur(){
		this.add(panelCouleur,BorderLayout.WEST);
	}
	
	public void addPanelVitesse(){
		this.add(panelVitesse,BorderLayout.WEST);
	}
}
