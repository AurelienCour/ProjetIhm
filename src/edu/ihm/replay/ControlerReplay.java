package edu.ihm.replay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class permettant la gestion des intéraction avec le panel Replay
 * @author Aurelien
 *
 */
public class ControlerReplay implements ActionListener {
	
	private String idButton; // L'id du bouton
	private PanelCommandeReplay panelCommandeReplay; // Le panel contenant les boutons
	private ModelReplay model; // Le model contenant les données

	/**
	 * Le constructeur de la classe
	 * @param idButton L'id du bouton
	 * @param panelCommandeReplay Le panel contenant les bouton
	 * @param model Le model contenant les données
	 */
	public ControlerReplay(String idButton, PanelCommandeReplay panelCommandeReplay, ModelReplay model) {
		this.model = model;
		this.idButton = idButton;
		this.panelCommandeReplay = panelCommandeReplay;
	}

	/**
	 * Fonction permettant la gestion des différentes intéractions
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(idButton.equals("lecture")){
			panelCommandeReplay.setBouton(false,false);
			model.lecture();
		}
		else if(idButton.equals("reset")){
			panelCommandeReplay.setBouton(true,true);
			model.reset();
		}
		else if(idButton.equals("suivant")){
			panelCommandeReplay.setBouton(false,true);
			model.actSuivante();
		}
	}

}
