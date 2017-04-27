package edu.ihm.resolution;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import edu.ihm.tortue.TortueRapide;

/**
 * Panel permettant le gestion de la vitesse pour une tortue rapide
 * Va modifier un objet de type TortueRapide a l'aide du ControlerTortueG
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelVitesse extends JPanel{
	
	private JLabel vitesse;
	private TortueRapide myTurtle;

	public PanelVitesse(TortueRapide myTurtle,PanelResolution panelRes){
		this.myTurtle = myTurtle;
		
		this.setLayout(new BorderLayout());
		vitesse = new JLabel(Integer.toString(myTurtle.getVitesse()));
		vitesse.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(vitesse, BorderLayout.CENTER);
		
		JPanel panelReglageVitesse = new JPanel();
		panelReglageVitesse.setLayout(new GridLayout(1,2));
		JButton addSpeed = new JButton("+");
		addSpeed.addActionListener(new ControlerResolution(this,"add",myTurtle,panelRes));
		JButton removeSpeed = new JButton("-");
		removeSpeed.addActionListener(new ControlerResolution(this,"remove",myTurtle,panelRes));
		
		panelReglageVitesse.add(removeSpeed);
		panelReglageVitesse.add(addSpeed);
		
		this.add(panelReglageVitesse,BorderLayout.SOUTH);
	}

	public void changeVitesse(String newVitesse) {
		vitesse.setText(newVitesse);
	}
	
	
}