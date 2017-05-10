package edu.ihm.replay;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import edu.ihm.noyau_fonctionnel.Tentative;
import edu.ihm.tortue.TortueG;

/**
 * Panel composé de toutes les commandes utilisées pour la visualisation d'une tentative
 * @author Aurelien
 *
 */
public class PanelCommandeReplay extends JPanel{
	
	private JButton lect; // Le bouton permettant la lecture
	private JButton actS; // Le bouton permettant le passage a l'action suivante
	
	/**
	 * Le constructeur de la classe
	 * @param myTurtle La tortue que l'on souhaite déplacé
	 * @param tentative La tentative a visualiser
	 */
	public PanelCommandeReplay(TortueG myTurtle, Tentative tentative){
		this.setLayout(new GridLayout(1,4));
		lect = new JButton("LECTURE");
		ModelReplay model = new ModelReplay(this,myTurtle,tentative);
		lect.setPreferredSize(new Dimension(1, 55));
		lect.addActionListener(new ControlerReplay("lecture",this,model));
		JButton reset = new JButton("MISE A ZERO");
		reset.addActionListener(new ControlerReplay("reset",this,model));
		actS = new JButton("ACTION SUIVANTE");
		actS.addActionListener(new ControlerReplay("suivant",this,model));
		if(tentative.getListeAction().isEmpty()){
			reset.setEnabled(false);
			actS.setEnabled(false);
			lect.setEnabled(false);
		}
		this.add(lect);
		this.add(reset);
		this.add(actS);
	}
	
	/**
	 * Permet de modifier l'état des boutons enable/disable
	 * @param etat1 True pour activer le bouton de lecture
	 * @param etat2 True pour activer le bouton d'action suivante
	 */
	public void setBouton(boolean etat1,boolean etat2){
		lect.setEnabled(etat1);
		actS.setEnabled(etat2);
	}
}
