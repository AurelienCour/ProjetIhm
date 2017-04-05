package edu.ihm.fiche_enfant_prof;


import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;

/**
 * Panel de visualisation de la fiche d'un enfant
 * Va utiliser un objet de type Eleve
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelFicheEnfantProf extends JPanel{
	
	private Eleve eleve;
	
	public PanelFicheEnfantProf(Eleve eleve){
		this.eleve = eleve;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		JLabel nom = new JLabel(eleve.getNom()+" "+eleve.getPrenom());
		JPanel exercice = new JPanel();
		exercice.setLayout(new BoxLayout(exercice,BoxLayout.Y_AXIS));
		boolean toto = false;
		for (Exercice exo : eleve.getClasse().getExercices()) {
			JPanel panelExo = new JPanel();
			panelExo.setLayout(new GridLayout(1,2));
			panelExo.add(new JLabel(exo.getNomEx()));
			if(!eleve.getExerciceRealise().isEmpty()){
				for (ExerciceRealise exoR : eleve.getExerciceRealise()) {
					if(exoR.getExerciceFait().equals(exo)){
						panelExo.add(new JLabel("FAIT"));
						toto = true;
					}
					else
						toto = false;
				}
			}
			if(!toto)
				panelExo.add(new JLabel("A FAIRE"));
			exercice.add(panelExo);
		}
		this.add(new JLabel(new ImageIcon(new ImageIcon(eleve.getPhoto()).getImage())));
		this.add(nom);
		this.add(exercice);
	}

}
