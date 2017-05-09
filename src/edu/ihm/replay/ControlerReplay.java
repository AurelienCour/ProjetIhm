package edu.ihm.replay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import edu.ihm.noyau_fonctionnel.Action;
import edu.ihm.noyau_fonctionnel.Tentative;
import edu.ihm.tortue.TortueCouleur;
import edu.ihm.tortue.TortueG;
import edu.ihm.tortue.TortueRapide;

public class ControlerReplay implements ActionListener {
	
	private String idButton;
	private PanelCommandeReplay panelCommandeReplay;
	private ModelReplay model;

	public ControlerReplay(String idButton, PanelCommandeReplay panelCommandeReplay, ModelReplay model) {
		this.model = model;
		this.idButton = idButton;
		this.panelCommandeReplay = panelCommandeReplay;
	}

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
