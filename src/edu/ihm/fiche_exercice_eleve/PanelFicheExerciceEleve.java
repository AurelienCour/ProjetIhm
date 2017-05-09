package edu.ihm.fiche_exercice_eleve;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.ihm.acceuil.AcceuilEleve;
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
	public PanelFicheExerciceEleve(Exercice exercice, Utilisateur user, AcceuilEleve acceuilEleve){
		this.exercice = exercice;
		this.user = (Eleve) user;
		
		this.setLayout(new BorderLayout());
		
		JPanel nord = new JPanel();
		nord.setLayout(new BorderLayout());
		JPanel description = new JPanel();
		description.setLayout(new GridLayout(2, 1));
		JLabel nom = new JLabel("        Nom : "+exercice.getNomEx());
		nom.setFont(new Font("Arial", Font.PLAIN, 20));
		JLabel type = new JLabel("        Type : "+exercice.getTypeEx());
		type.setFont(new Font("Arial", Font.PLAIN, 20));
		description.add(nom);
		description.add(type);
		nord.add(description,BorderLayout.WEST);
		nord.add(new JLabel(new ImageIcon(new ImageIcon(exercice.getModele()).getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT))),BorderLayout.EAST);
		this.add(nord,BorderLayout.NORTH);
		
		JPanel corp = new JPanel();
		corp.setLayout(new BoxLayout(corp,BoxLayout.Y_AXIS));
		boolean exerciceFait = false;
		JButton faire = new JButton("Faire");
		for (ExerciceRealise exerciceR : this.user.getExerciceRealise()) {
			if(exerciceR.getExerciceFait().equals(exercice)){
				exerciceFait = true;
				if(exerciceR.getResultat() != null){
					corp.add(new PanelResultat(exerciceR));
				}
				else{
					corp.add(new PanelTentative(exerciceR));
				}
				break;
			}
		}
		if(!exerciceFait){
			corp.add(new JLabel("Exercice a faire"));
		}
		corp.add(faire);
		faire.addActionListener(new ControlerPanelFicheExerciceEleve(exercice,this.user,acceuilEleve));
		this.add(corp,BorderLayout.CENTER);
	}

}
