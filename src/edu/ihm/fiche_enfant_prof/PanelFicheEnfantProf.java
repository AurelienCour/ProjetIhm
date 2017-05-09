package edu.ihm.fiche_enfant_prof;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
		this.setLayout(new BorderLayout());
		
		JPanel nord = new JPanel();
		nord.setLayout(new BorderLayout());
		JLabel nom = new JLabel("        "+eleve.getNom()+" "+eleve.getPrenom());
		nom.setFont(new Font("Arial", Font.PLAIN, 20));
		
		nord.add(nom,BorderLayout.WEST);
		nord.add(new JLabel(new ImageIcon(new ImageIcon(eleve.getPhoto()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT))),BorderLayout.EAST);
		
		String debutListe = "<html><body><h1 style=\"text-decoration: underline;margin:15px\">Liste des exercices :</h1><ul>";
		String finListe="</ul></body></html>";
		String corp="";
		boolean fait;
		for (Exercice exo : eleve.getClasse().getExercices()) {
			fait = false;
			corp += "<li>"+exo.getNomEx();
			if(!eleve.getExerciceRealise().isEmpty()){
				for (ExerciceRealise exoR : eleve.getExerciceRealise()) {
					if(exoR.getExerciceFait().equals(exo)){
						corp += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FAIT</li>";
						fait = true;
						break;
					}
				}
			}
			if(!fait)
				corp += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A FAIRE</li>";
		}
		JLabel listeExo = new JLabel(debutListe+corp+finListe);
		listeExo.setVerticalAlignment(SwingConstants.TOP);
		listeExo.setFont(new Font("Arial", Font.PLAIN, 20));
		this.add(nord, BorderLayout.NORTH);
		this.add(listeExo, BorderLayout.CENTER);
	}

}
