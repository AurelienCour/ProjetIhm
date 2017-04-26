package edu.ihm.fiche_exercice_eleve;

import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.ihm.noyau_fonctionnel.Eleve;
import edu.ihm.noyau_fonctionnel.Exercice;
import edu.ihm.noyau_fonctionnel.ExerciceRealise;
import edu.ihm.noyau_fonctionnel.Utilisateur;

/**
 * Panel permettant à un eleve de visualiser la fiche d'un exercice
 * Va utiliser un objet de type Exercice
 * @author Groupe8
 * @version 30/03/2017
 */
public class PanelFicheExerciceEleve extends JPanel{
	
	private Exercice exercice;
	private Eleve user;
	public PanelFicheExerciceEleve(Exercice exercice, Utilisateur user){
		this.exercice = exercice;
		this.user = (Eleve) user;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(new JLabel(new ImageIcon(new ImageIcon(exercice.getModele()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))));
		this.add(new JLabel(exercice.getNomEx()));
		this.add(new JLabel(exercice.getTypeEx()));
		boolean exerciceFait = false;
		JButton faire = new JButton("Faire");
		for (ExerciceRealise exerciceR : this.user.getExerciceRealise()) {
			if(exerciceR.getExerciceFait().equals(exercice)){
				exerciceFait = true;
				if(exerciceR.getResultat() != null){
					this.add(new PanelResultat(exerciceR));
					this.add(faire);
				}
				else{
					this.add(new PanelTentative(exerciceR));
					this.add(faire);
				}
				break;
			}
		}
		if(!exerciceFait){
			this.add(new JLabel("Exercice a faire"));
			this.add(faire);
		}
		faire.addActionListener(new ControlerPanelFicheExerciceEleve(exercice,this.user));
	}

}
