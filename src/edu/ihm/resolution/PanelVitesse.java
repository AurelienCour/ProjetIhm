package edu.ihm.resolution;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import edu.ihm.tortue.TortueRapide;

/**
 * Panel comportant tous les boutons pour la gestion de la vitesse de la tortue
 * @author Aurelien
 *
 */
public class PanelVitesse extends JPanel{
	
	private JLabel vitesse; // Le label affichant la vitesse
	private TortueRapide myTurtle; // La tortue à déplacer

	/**
	 * Le constructeur de la classe
	 * @param myTurtle La tortue a déplacer
	 * @param panelRes La panel contenant les boutons de base
	 */
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

	/**
	 * Permet de modifier la valeur du JLabel affichant la vitesse
	 * @param newVitesse La vitesse à afficher
	 */
	public void changeVitesse(String newVitesse) {
		vitesse.setText(newVitesse);
	}
	
	
}